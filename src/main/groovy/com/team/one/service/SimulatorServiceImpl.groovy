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

  static Integer MONTHS_IN_A_YEAR = 12
  static Integer DECIMALS = 2

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
    //command.tim = (tia/12.toDouble()).round(2)
    command.tim = tia? tia.divide(MONTHS_IN_A_YEAR, DECIMALS, BigDecimal.ROUND_HALF_UP) : 0.00
    pmtService.calculate(command)
    command
  }
}
