package com.team.one.service

import com.team.one.domain.SimulatorCommand
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import com.team.one.domain.Paydays
import com.team.one.exception.SimulatorException

@Service
class InsuranceServiceImpl implements InsuranceService {

  def calculate(SimulatorCommand command){
    command.principle = command.loan + command.lifeInsurance
    command
  }
}
