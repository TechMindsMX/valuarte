package com.team.one.service

import com.team.one.domain.Simulator
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import com.team.one.exception.SimulatorException

@Service
class InsuranceServiceImpl implements InsuranceService {

  def calculate(Simulator simulator){
    if(!simulator.loan)
      throw new SimulatorException()

    simulator.principle = simulator.loan + simulator.lifeInsurance
    simulator
  }

}
