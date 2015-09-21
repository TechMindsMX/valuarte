package com.team.one.service

import com.team.one.domain.SimulatorCommand
import org.springframework.stereotype.Service
import com.team.one.domain.SimulatorPayment
import com.team.one.exception.SimulatorException

@Service
class SimulatorDataServiceImpl implements SimulatorDataService {

  def calculate(SimulatorCommand command){
    if(!command.numberOfPayments || command.numberOfPayments == 0)
      throw new SimulatorException()
    (1..command.numberOfPayments).each {
      def data = new SimulatorPayment()
      data.capitalBeforePayment = command.principle
      command.rows.add(data)
    }
    command
  }

}
