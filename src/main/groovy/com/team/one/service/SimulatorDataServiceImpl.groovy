package com.team.one.service

import com.team.one.domain.Simulator
import org.springframework.stereotype.Service
import com.team.one.domain.SimulatorRow
import org.springframework.beans.factory.annotation.Autowired
import com.team.one.exception.SimulatorException

@Service
class SimulatorDataServiceImpl implements SimulatorDataService {

  @Autowired
  DatePaymentService datePaymentService
  @Autowired
  InterestService interestService

  def calculate(Simulator simulator){
    if(!simulator.numberOfPayments || simulator.numberOfPayments == 0)
      throw new SimulatorException()

    def capitalBeforePayment = simulator.principle
    def paymentDates = datePaymentService.generatePaymentDates(simulator)

    (1..simulator.numberOfPayments).each { n ->
      def data = new SimulatorRow(capital:228.92)
      data.number = n
      data.capitalBeforePayment = capitalBeforePayment
      data.capitalAfterPayment = capitalBeforePayment - data.capital
      capitalBeforePayment -= data.capital
      data.paymentDate = paymentDates.get(n-1)
      interestService.calculate(data.capital, simulator.paymentPeriod)
      simulator.rows.add(data)
    }
    simulator
  }

}
