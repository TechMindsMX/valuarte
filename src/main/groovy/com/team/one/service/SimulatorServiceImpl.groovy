package com.team.one.service

import com.team.one.domain.SimulatorCommand
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import com.team.one.domain.Paydays


@Service
class SimulatorServiceImpl implements SimulatorService{

  static Integer MONTHS_IN_A_YEAR = 12
  static Integer DECIMALS = 2

  def calculate(SimulatorCommand command){
    def tia = command.tia
    //command.tim = (tia/12.toDouble()).round(2)
    command.tim = tia.divide(MONTHS_IN_A_YEAR, DECIMALS, BigDecimal.ROUND_HALF_UP)
    if(command.paymentPeriod == PaymentPeriod.WEEKLY){
      command.paydays = Paydays.WEEKLY
    }
    command
  }
}
