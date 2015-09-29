package com.team.one.service

import com.team.one.domain.SimulatorCommand
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import com.team.one.state.ApplicationConstants
import com.team.one.exception.SimulatorException

@Service
class PMTServiceImpl implements PMTService{

  def calculate(SimulatorCommand command){
    if(!command.paymentPeriod){
      throw new SimulatorException()
    }

    BigDecimal effectiveInterest = command.tia / 100 / 12 / command.paymentPeriod.factor
    BigDecimal effectiveInterestPlusIVA = effectiveInterest * (1 + (command.iva / 100))
    BigDecimal effectiveInterestPlusIVAPower = (1 + effectiveInterestPlusIVA) ** (-1 * command.numberOfPayments)
    BigDecimal effectiveInterestFactor = effectiveInterestPlusIVA / (1 - effectiveInterestPlusIVAPower)
    BigDecimal result = effectiveInterestFactor  * command.loan
    command.payment = result.setScale(ApplicationConstants.DECIMALS, ApplicationConstants.ROUNDING_MODE)
    command
  }

}
