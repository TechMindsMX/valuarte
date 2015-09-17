package com.team.one.service

import com.team.one.domain.SimulatorCommand

interface SimulatorService {
  def calculate(SimulatorCommand command)
}
