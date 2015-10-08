package com.team.one.service

import spock.lang.Specification
import spock.lang.Unroll

import com.team.one.domain.Simulator
import com.team.one.service.impl.SimulatorDataServiceImpl
import com.team.one.exception.SimulatorException

class SimulatorDataServiceSpec extends Specification {

  SimulatorDataServiceImpl service = new SimulatorDataServiceImpl()

  Integer decimals = 2
  String roundingMode = 'HALF_UP'

  def datePaymentService = Mock(DatePaymentService)
  def interestService = Mock(InterestService)
  def ppmtService = Mock(PPMTService)
  def insuranceDataService = Mock(InsuranceDataService)

  def interest = new BigDecimal(100.00)
  def capital = new BigDecimal(228.92)

  def setup(){
    service.datePaymentService = datePaymentService
    service.insuranceDataService = insuranceDataService
    service.interestService = interestService
    service.ppmtService = ppmtService

    datePaymentService.generatePaymentDates(_) >> [new Date(), new Date(), new Date()]
    insuranceDataService.calculate(_) >> [100,200,300]
    interestService.calculate(_, _) >> interest
    ppmtService.calculate(_, _, _) >> capital

    service.decimals = decimals
    service.roundingMode = roundingMode
  }

  @Unroll
  void """When we have number of payments: #numberOfPayments and we expect #result rows in the table"""() {
    given:"A simulator"
      def simulator = new Simulator()
      simulator.principle = 35165.88
      simulator.iva = 16
    when:"Input values"
      simulator.numberOfPayments = numberOfPayments
    then:"We calculate values"
      result == service.calculate(simulator).size()
    where:"We have next cases"
    numberOfPayments || result
    3                || 3
    1                || 1
  }

  @Unroll
  void """given number of payments as: #numberOfPayments we expect thown exception"""() {
    given:"A simulator"
      def simulator = new Simulator()
      simulator.numberOfPayments = numberOfPayments
      simulator.principle = 35164.88
      simulator.iva = 16
    when:"Input values"
      service.calculate(simulator)
    then:"We calculate values"
      thrown SimulatorException
    where:"We have next cases"
      numberOfPayments << [null, 0, -1]
  }

  void "should set capital before and after payment"() {
    given:"A simulator and principle"
      def simulator = new Simulator()
      simulator.numberOfPayments = 3
      simulator.principle = 35164.88
      simulator.iva = 16
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
    given:"A simulator and principle"
      def simulator = new Simulator()
      simulator.numberOfPayments = 3
      simulator.principle = 35164.88
      simulator.iva = 16
    when:"We calculate data"
      def result = service.calculate(simulator)
    then:"We expect same principle with capital before payment"
      result.get(0).number == 1
      result.get(1).number == 2
      result.get(2).number == 3
  }

  void "should set number dates depending on numberOfPayments"() {
    given:"A simulator and principle"
      def simulator = new Simulator()
      simulator.numberOfPayments = 2
      simulator.principle = 35164.88
      simulator.iva = 16
    when:"We calculate data"
      def result = service.calculate(simulator)
    then:"We expect same principle with capital before payment"
      result.get(0).paymentDate instanceof Date
      result.get(1).paymentDate instanceof Date
  }

  void "should get interest"() {
    given:"A simulator"
      def simulator = new Simulator()
      simulator.numberOfPayments = 1
      simulator.principle = 35164.88
      simulator.iva = 16
    when:"We compute data"
      def result = service.calculate(simulator)
    then:"We expect interest"
      100.00 == result.get(0).interest
  }

  void "should get IVA"(){
    given:"A simulator"
      def simulator = new Simulator()
      simulator.numberOfPayments = 1
      simulator.principle = 35164.88
      simulator.iva = 16
    when:"We compute data"
      def result = service.calculate(simulator)
    then:"We expect IVA"
      16 == result.get(0).iva
  }

}
