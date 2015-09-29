package com.team.one.service

import com.team.one.domain.SimulatorCommand
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import com.team.one.domain.Paydays
import com.team.one.state.ApplicationConstants
import com.team.one.exception.SimulatorException

@Service
class InterestServiceImpl implements InterestService {

  def calculate(BigDecimal capitalBeforePayment, SimulatorCommand command){
    if(!capitalBeforePayment || !command?.tia)
      return 0

    if(!command.paymentPeriod) {
      throw new SimulatorException()
    }

    BigDecimal result = 0
    result = capitalBeforePayment * command.tia / 12 / 100 / command.paymentPeriod.factor
    result.setScale(ApplicationConstants.DECIMALS, ApplicationConstants.ROUNDING_MODE)
  }

}
