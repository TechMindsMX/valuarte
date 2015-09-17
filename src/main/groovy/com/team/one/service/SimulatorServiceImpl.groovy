package com.team.one.service

import com.team.one.domain.SimulatorCommand
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import com.team.one.domain.Paydays
import com.team.one.exception.SimulatorException

@Service
class SimulatorServiceImpl implements SimulatorService{

  static Integer MONTHS_IN_A_YEAR = 12
  static Integer DECIMALS = 2

  def calculate(SimulatorCommand command){
    if(command.paymentPeriod == PaymentPeriod.WEEKLY){
      command = new SimulatorWeeklyCommand()
    } else if(command.paymentPeriod == PaymentPeriod.MONTHLY){
      command = new SimulatorMonthlyCommand()
    } else if(command.paymentPeriod == PaymentPeriod.FORTNIGHT){
      command = new SimulatorFortnightCommand()
    } else {
      throw new SimulatorException()
    }

    def tia = command.tia
    //command.tim = (tia/12.toDouble()).round(2)
    command.tim = tia? tia.divide(MONTHS_IN_A_YEAR, DECIMALS, BigDecimal.ROUND_HALF_UP) : 0.00
    command
  }
}
