package com.team.one.service

import com.team.one.domain.SimulatorCommand
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import com.team.one.domain.Paydays
import com.team.one.state.ApplicationConstants
import com.team.one.exception.SimulatorException

@Service
class PMTServiceImpl implements PMTService{

  def calculate(SimulatorCommand command){
    if(command.paymentPeriod == PaymentPeriod.MONTHLY){
      def payment = command.tia/24/100*command.loan
      command.payment = payment.setScale(ApplicationConstants.DECIMALS, ApplicationConstants.ROUNDING_MODE)
    }
    command
  }

}
