package com.team.one.service

import org.springframework.beans.factory.annotation.Value
import java.math.RoundingMode
import com.team.one.domain.Simulator
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import com.team.one.exception.SimulatorException

@Service
class PPMTServiceImpl implements PPMTService {

  @Value('${simulator.decimals}')
  Integer decimals
  @Value('${simulator.roundingMode}')
  String roundingMode

  BigDecimal calculate(Simulator simulator, BigDecimal base, Integer numberPayment){
    if(!simulator.paymentPeriod){
      throw new SimulatorException()
    }

    if(!simulator.tia || simulator.tia < 0){
      throw new SimulatorException()
    }

    if(!base || base < 0){
      throw new SimulatorException()
    }

    BigDecimal effectiveInterest = simulator.tia / 100 / 12 / simulator.paymentPeriod.factor
    BigDecimal effectiveInterestPlusIVA = effectiveInterest * (1 + (simulator.iva / 100))
    BigDecimal effectiveInterestPlusIVAPower = (1 + effectiveInterestPlusIVA) ** (-1 * simulator.numberOfPayments)
    BigDecimal effectiveInterestPlusIVAPowerPayment = (1 + effectiveInterestPlusIVA) ** (-1 * numberPayment)
    BigDecimal effectiveInterestFactor = effectiveInterestPlusIVA / (1 - effectiveInterestPlusIVAPower)
    BigDecimal result = effectiveInterestFactor * base
    (effectiveInterestPlusIVAPowerPayment * result).setScale(decimals, RoundingMode.valueOf(roundingMode))
  }

}
