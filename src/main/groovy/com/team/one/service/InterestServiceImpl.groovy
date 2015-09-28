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

   BigDecimal result = 0
   switch(command.paymentPeriod){
     case PaymentPeriod.MONTHLY:
       result = capitalBeforePayment * command.tia / 12 / 100
       break
     case PaymentPeriod.FORTNIGHT:
       result = capitalBeforePayment * command.tia / 12 / 100 / 2
       break
     case PaymentPeriod.WEEKLY:
       result = capitalBeforePayment * command.tia / 12 / 100 / 4
       break
     default:
       throw new SimulatorException()
   }
   result.setScale(ApplicationConstants.DECIMALS, ApplicationConstants.ROUNDING_MODE)
  }

}
