package com.team.one.service.impl

import com.team.one.domain.Simulator
import com.team.one.service.PMTService
import com.team.one.service.InsuranceService
import com.team.one.service.SimulatorService
import com.team.one.service.OpeningCommissionService
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import org.springframework.beans.factory.annotation.Autowired

import com.team.one.repository.SimulatorRepository
import com.team.one.exception.SimulatorException

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Service
class SimulatorServiceImpl implements SimulatorService {

  @Autowired
  PMTService pmtService
  @Autowired
  InsuranceService insuranceService
  @Autowired
  OpeningCommissionService openingCommissionService
  @Autowired
  SimulatorRepository simulatorRepository

  Logger log = LoggerFactory.getLogger(getClass())

  def calculate(Simulator simulator){
    if(!simulator.paymentPeriod){
      throw new SimulatorException()
    }

    simulator.openingCommission = openingCommissionService.calculate(simulator)
    simulator.lifeInsurance = insuranceService.calculate(simulator)
    simulator.principle = simulator.loan + simulator.lifeInsurance + simulator.openingCommission
    simulator.payment = pmtService.calculate(simulator)

    simulator
  }

  def save(Simulator simulator){
    simulatorRepository.save(simulator)
  }

}
