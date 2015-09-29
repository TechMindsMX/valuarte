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
      def effectiveInterest = command.tia / 100 / 12
      def effectiveInterestPlusIVA = effectiveInterest * (1 + (command.iva / 100))
      command.payment = effectiveInterestPlusIVA.setScale(ApplicationConstants.DECIMALS, ApplicationConstants.ROUNDING_MODE)
    }
    command
  }

}
