package com.team.one.service.impl

import com.team.one.domain.Simulator
import com.team.one.service.PMTService
import com.team.one.service.InsuranceService
import com.team.one.service.SimulatorService
import com.team.one.service.OpeningCommissionService
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value

import com.team.one.repository.SimulatorRepository
import com.team.one.command.SeguroMedicoCommand
import com.team.one.exception.SimulatorException

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Service
class SimulatorValuarteServiceImpl implements SimulatorService {

  @Value('${simulator.tiav}')
  BigDecimal tiav

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
    def valuarte = simulator.copy()
    if(!valuarte.paymentPeriod){
      throw new SimulatorException()
    }

    valuarte.tia = tiav
    valuarte.openingCommission = openingCommissionService.calculate(valuarte)
    valuarte.lifeInsurance = insuranceService.calculate(valuarte)
    valuarte.principle = valuarte.loan + valuarte.lifeInsurance + valuarte.openingCommission
    valuarte.payment = pmtService.calculate(valuarte)

    valuarte
  }

  def getCostOfHealthInsurance(SeguroMedicoCommand command) {}

}
