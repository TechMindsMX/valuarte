package com.team.one.service

import com.team.one.domain.SimulatorCommand

interface InsuranceService {
  def calculate(SimulatorCommand command)
}
