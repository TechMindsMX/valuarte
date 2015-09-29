package com.team.one.service

import com.team.one.domain.SimulatorCommand
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import com.team.one.domain.Paydays
import org.springframework.beans.factory.annotation.Autowired
import com.team.one.exception.SimulatorException

@Service
class SimulatorServiceImpl implements SimulatorService{

  @Autowired
  PMTService pmtService

  def calculate(SimulatorCommand command){
    if(command.paymentPeriod == PaymentPeriod.WEEKLY){
      command.paydays = Paydays.WEEKLY.getValue()
    } else if(command.paymentPeriod == PaymentPeriod.FORTNIGHT){
      command.paydays = Paydays.FORTNIGHT.getValue()
    } else if(command.paymentPeriod == PaymentPeriod.MONTHLY){
      command.paydays = Paydays.MONTHLY.getValue()
    } else {
      throw new SimulatorException()
    }

    def tia = command.tia
    pmtService.calculate(command)
    command
  }
}
