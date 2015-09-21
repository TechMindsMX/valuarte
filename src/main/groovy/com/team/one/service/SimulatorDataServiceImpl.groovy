package com.team.one.service

import com.team.one.domain.SimulatorCommand
import org.springframework.stereotype.Service
import com.team.one.domain.SimulatorPayment
import com.team.one.exception.SimulatorException

@Service
class SimulatorDataServiceImpl implements SimulatorDataService {

  def calculate(SimulatorCommand command){
    def data = new SimulatorPayment()
    command.rows.add(data)
    command
  }

}
