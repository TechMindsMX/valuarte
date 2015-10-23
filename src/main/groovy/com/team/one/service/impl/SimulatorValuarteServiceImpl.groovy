package com.team.one.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

import com.team.one.domain.Simulator
import com.team.one.service.SimulatorService
import com.team.one.domain.PaymentPeriod
import com.team.one.collaborator.SimulatorCollaborator
import com.team.one.command.SeguroMedicoCommand

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Service
class SimulatorValuarteServiceImpl implements SimulatorService {

  @Value('${simulator.tiav}')
  BigDecimal tiav

  @Autowired
  SimulatorCollaborator simulatorCollaborator

  Logger log = LoggerFactory.getLogger(getClass())

  def calculate(Simulator simulator){
    def valuarte = simulator.copy()
    valuarte.tia = tiav
    simulatorCollaborator.calculate(valuarte)
  }

  def getCostOfHealthInsurance(SeguroMedicoCommand command) {}

}
