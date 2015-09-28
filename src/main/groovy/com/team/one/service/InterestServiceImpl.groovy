package com.team.one.service

import com.team.one.domain.SimulatorCommand
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import com.team.one.domain.Paydays
import java.math.RoundingMode

@Service
class InterestServiceImpl implements InterestService {

  def calculate(BigDecimal capitalBeforePayment, SimulatorCommand command){
    if(!capitalBeforePayment || !command?.tia)
      return 0
   def result =  capitalBeforePayment * command.tia / 12 / 100
   result.setScale(2, RoundingMode.HALF_UP)
  }

}
