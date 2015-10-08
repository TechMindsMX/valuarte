package com.team.one.service.impl

import com.team.one.domain.Simulator
import com.team.one.service.PMTService
import com.team.one.service.InsuranceService
import com.team.one.service.SimulatorService
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import org.springframework.beans.factory.annotation.Autowired
import com.team.one.exception.SimulatorException

@Service
class SimulatorServiceImpl implements SimulatorService {

  @Autowired
  PMTService pmtService
  @Autowired
  InsuranceService insuranceService

  def calculate(Simulator simulator){
    if(!simulator.paymentPeriod){
      throw new SimulatorException()
    }

    simulator.lifeInsurance = insuranceService.calculate(simulator)
    simulator.principle = simulator.loan + simulator.lifeInsurance
    simulator.payment = pmtService.calculate(simulator)
    simulator
  }
}
