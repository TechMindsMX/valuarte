package com.team.one.service

import com.team.one.domain.Simulator
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import com.team.one.state.ApplicationConstants
import com.team.one.exception.SimulatorException

@Service
class PMTServiceImpl implements PMTService {

  def calculate(Simulator simulator){
    if(!simulator.paymentPeriod){
      throw new SimulatorException()
    }

    BigDecimal effectiveInterest = simulator.tia / 100 / 12 / simulator.paymentPeriod.factor
    BigDecimal effectiveInterestPlusIVA = effectiveInterest * (1 + (simulator.iva / 100))
    BigDecimal effectiveInterestPlusIVAPower = (1 + effectiveInterestPlusIVA) ** (-1 * simulator.numberOfPayments)
    BigDecimal effectiveInterestFactor = effectiveInterestPlusIVA / (1 - effectiveInterestPlusIVAPower)
    BigDecimal result = effectiveInterestFactor  * simulator.loan
    simulator.payment = result.setScale(ApplicationConstants.DECIMALS, ApplicationConstants.ROUNDING_MODE)
    simulator
  }

}
