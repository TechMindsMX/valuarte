package com.team.one.service

import com.team.one.domain.SimulatorCommand
import org.springframework.stereotype.Service

@Service
class SimulatorServiceImpl implements SimulatorService{

  def calculate(SimulatorCommand command){
    command.tim = command.tia.divide(new BigDecimal(12), 2, BigDecimal.ROUND_HALF_UP)
    command
  }
}
