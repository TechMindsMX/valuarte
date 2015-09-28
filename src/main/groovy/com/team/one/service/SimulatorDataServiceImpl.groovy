package com.team.one.service

import com.team.one.domain.SimulatorCommand
import org.springframework.stereotype.Service
import com.team.one.domain.SimulatorPayment
import org.springframework.beans.factory.annotation.Autowired
import com.team.one.exception.SimulatorException

@Service
class SimulatorDataServiceImpl implements SimulatorDataService {

  @Autowired
  DatePaymentService datePaymentService
  @Autowired
  InterestService interestService

  def calculate(SimulatorCommand command){
    if(!command.numberOfPayments || command.numberOfPayments == 0)
      throw new SimulatorException()

    def capitalBeforePayment = command.principle
    def paymentDates = datePaymentService.generatePaymentDates(command)

    (1..command.numberOfPayments).each { n ->
      def data = new SimulatorPayment(capital:228.92)
      data.number = n
      data.capitalBeforePayment = capitalBeforePayment
      data.capitalAfterPayment = capitalBeforePayment - data.capital
      capitalBeforePayment -= data.capital
      data.paymentDate = paymentDates.get(n-1)
      interestService.calculate(data.capital)
      command.rows.add(data)
    }
    command
  }

}
