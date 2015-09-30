package com.team.one.service

import spock.lang.Specification
import spock.lang.Unroll

import com.team.one.domain.Simulator
import com.team.one.service.SimulatorDataServiceImpl
import com.team.one.service.DatePaymentService
import com.team.one.domain.PaymentPeriod
import com.team.one.exception.SimulatorException

class SimulatorDataServiceSpec extends Specification {

  SimulatorDataServiceImpl service = new SimulatorDataServiceImpl()

  def datePaymentService = Mock(DatePaymentService)
  def interestService = Mock(InterestService)

  def setup(){
    service.datePaymentService = datePaymentService
    service.interestService = interestService

    datePaymentService.generatePaymentDates(_) >> [new Date(), new Date(), new Date()]
    interestService.calculate(_, _) >> 100.00
  }

  @Unroll
  void """When we have number of payments: #numberOfPayments and we expect #result rows in the table"""() {
    given:"A simulator simulator"
      def simulator = new Simulator()
      simulator.principle = 35165.88
    when:"Input values"
      simulator.numberOfPayments = numberOfPayments
    then:"We calculate values"
      result == service.calculate(simulator).size()
    where:"We have next cases"
    numberOfPayments || result
    3                || 3
    1                || 1
  }

  void "should detect an invalid number at calculate table size depending on number of payments"() {
    given:"A simulator simulator"
      def simulator = new Simulator()
      simulator.numberOfPayments = 0
    when:"Input values"
      service.calculate(simulator)
    then:"We calculate values"
      thrown SimulatorException
  }

  void "should set capital before and after payment"() {
    given:"A simulator simulator and principle"
      def simulator = new Simulator()
      simulator.numberOfPayments = 3
      simulator.principle = 35164.88
    when:"We calculate data"
      def result = service.calculate(simulator)
    then:"We expect same principle with capital before payment"
      result.get(0).capitalBeforePayment == simulator.principle
      result.get(0).capitalAfterPayment ==  34935.96
      result.get(1).capitalBeforePayment ==  34935.96
      result.get(1).capitalAfterPayment ==   34707.04
      result.get(2).capitalBeforePayment ==  34707.04
      result.get(2).capitalAfterPayment ==   34478.12
  }

  void "should set number depending on numberOfPayments"() {
    given:"A simulator simulator and principle"
      def simulator = new Simulator()
      simulator.numberOfPayments = 3
      simulator.principle = 35164.88
    when:"We calculate data"
      def result = service.calculate(simulator)
    then:"We expect same principle with capital before payment"
      result.get(0).number == 1
      result.get(1).number == 2
      result.get(2).number == 3
  }

  void "should set number dates depending on numberOfPayments"() {
    given:"A simulator simulator and principle"
      def simulator = new Simulator()
      simulator.numberOfPayments = 2
      simulator.principle = 35164.88
    when:"We calculate data"
      def result = service.calculate(simulator)
    then:"We expect same principle with capital before payment"
      result.get(0).paymentDate instanceof Date
      result.get(1).paymentDate instanceof Date
  }

}
