package com.team.one.service.impl

import com.team.one.service.PMTService
import org.springframework.beans.factory.annotation.Value
import java.math.RoundingMode
import com.team.one.domain.Simulator
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import com.team.one.exception.SimulatorException

//TODO: Externalizar los mensajes de error

@Service
class PMTServiceImpl implements PMTService {

  @Value('${simulator.decimals}')
  Integer decimals
  @Value('${simulator.roundingMode}')
  String roundingMode

  BigDecimal calculate(Simulator simulator){
    if(!simulator.paymentPeriod){
      throw new SimulatorException('No se ha proporcionado un periodo de pago')
    }

    if(!simulator.tia || simulator.tia < 0){
      throw new SimulatorException('No se ha proporcionado una tasa de interés anual válida')
    }

    if(!simulator.principle || simulator.principle < 0){
      throw new SimulatorException('No se ha proporcionado el monto total del préstamo')
    }

    BigDecimal effectiveInterest = simulator.tia / 100 / 12 / simulator.paymentPeriod.factor
    BigDecimal effectiveInterestPlusIVA = effectiveInterest * (1 + (simulator.iva / 100))
    BigDecimal effectiveInterestPlusIVAPower = (1 + effectiveInterestPlusIVA) ** (-1 * simulator.numberOfPayments)
    BigDecimal effectiveInterestFactor = effectiveInterestPlusIVA / (1 - effectiveInterestPlusIVAPower)
    (effectiveInterestFactor  * simulator.principle).setScale(decimals, RoundingMode.valueOf(roundingMode))
  }

}
