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
import com.team.one.command.SeguroMedicoCommand
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
    def restructure = simulator.copy()

    if(!restructure.paymentPeriod){
      throw new SimulatorException()
    }

    restructure.openingCommission = openingCommissionService.calculate(restructure)
    restructure.lifeInsurance = insuranceService.calculate(restructure)
    restructure.principle = restructure.loan + restructure.lifeInsurance + restructure.openingCommission
    restructure.payment = pmtService.calculate(restructure)

    restructure
  }

  def save(Simulator simulator){
    simulatorRepository.save(simulator)
  }

  def getCostOfHealthInsurance(SeguroMedicoCommand command) {
    def agePivot = getAge(command.edad)
    agePivot

  }

  private def getAge(def edad) {
    if (edad < 20)
      return 1
    edad
  }

}
