package com.team.one.service

import com.team.one.domain.SimulatorCommand
import org.springframework.stereotype.Service

@Service
class SimulatorServiceImpl implements SimulatorService{

  def calculate(SimulatorCommand command){
    command.tim = new BigDecimal(0.00)
    command
  }
}
