package com.team.one.service.impl

import com.team.one.domain.Simulator
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

import com.team.one.service.SimulatorService
import com.team.one.repository.SimulatorRepository
import com.team.one.collaborator.SimulatorCollaborator
import com.team.one.command.SeguroMedicoCommand

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Service
class SimulatorServiceImpl implements SimulatorService {

  @Autowired
  SimulatorRepository simulatorRepository
  @Autowired
  SimulatorCollaborator simulatorCollaborator

  Logger log = LoggerFactory.getLogger(getClass())

  def calculate(Simulator simulator){
    def restructure = simulator.copy()
    simulatorCollaborator.calculate(restructure)
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
