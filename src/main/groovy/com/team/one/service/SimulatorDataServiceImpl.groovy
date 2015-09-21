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

    def capitalBeforePayment = command.principle
    (1..command.numberOfPayments).each {
      def data = new SimulatorPayment(capital:228.92)
      data.capitalBeforePayment = capitalBeforePayment
      data.capitalAfterPayment = capitalBeforePayment - data.capital
      capitalBeforePayment -= data.capital
      command.rows.add(data)
    }
    command
  }

}
