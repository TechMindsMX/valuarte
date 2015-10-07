package com.team.one.service.impl

import com.team.one.domain.Simulator
import com.team.one.service.DatePaymentService
import com.team.one.service.InterestService
import com.team.one.service.SimulatorDataService
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
    def rows = []
    if(!simulator.numberOfPayments || simulator.numberOfPayments < 0)
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
      data.interest = interestService.calculate(data.capital, simulator)
      data.iva = data.interest * simulator.iva / 100
      rows.add(data)
    }
    rows
  }

}
