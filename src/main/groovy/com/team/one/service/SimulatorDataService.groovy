package com.team.one.service

import com.team.one.domain.SimulatorCommand

interface SimulatorDataService {
  def calculate(SimulatorCommand command)
}
