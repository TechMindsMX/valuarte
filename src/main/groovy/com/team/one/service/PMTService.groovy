package com.team.one.service

import com.team.one.domain.SimulatorCommand

interface PMTService {
  def calculate(SimulatorCommand command)
}
