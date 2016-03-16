package com.team.one.service

import com.team.one.domain.Simulator
import com.team.one.command.SeguroMedicoCommand

interface SimulatorService {
  def calculate(Simulator simulator)

  def getCostOfHealthInsurance(SeguroMedicoCommand command)
}
