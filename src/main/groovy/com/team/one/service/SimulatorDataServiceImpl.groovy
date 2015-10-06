package com.team.one.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory

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
  @Autowired
  PPMTService ppmtService

  Logger log = LoggerFactory.getLogger(getClass());

  def calculate(Simulator simulator){
    def rows = []
    if(!simulator.numberOfPayments || simulator.numberOfPayments < 0)
      throw new SimulatorException()

    def capitalBeforePayment = simulator.principle
    def paymentDates = datePaymentService.generatePaymentDates(simulator)

    (1..simulator.numberOfPayments).each { n ->
      def data = new SimulatorRow()
      data.number = n
      data.capital = ppmtService.calculate(simulator, simulator.numberOfPayments - (n-1))
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
