package com.team.one.service

import spock.lang.Specification
import com.team.one.domain.SimulatorCommand
import com.team.one.service.SimulatorDataServiceImpl
import com.team.one.service.DatePaymentService
import com.team.one.domain.PaymentPeriod
import com.team.one.domain.Paydays
import com.team.one.exception.SimulatorException

class SimulatorDataServiceSpec extends Specification {

  SimulatorDataServiceImpl service = new SimulatorDataServiceImpl()

  def datePaymentService = Mock(DatePaymentService)
  def interestService = Mock(InterestService)

  def setup(){
    service.datePaymentService = datePaymentService
    service.interestService = interestService

    datePaymentService.generatePaymentDates(_) >> [new Date(), new Date(), new Date()]
    interestService.calculate(_) >> 100.00
  }

  void "should calculate table size depending on number of payments"() {
    given:"A simulator command"
      def command = new SimulatorCommand()
      command.principle = 35165.88
    when:"Input values"
      command.numberOfPayments = numberOfPayments
    then:"We calculate values"
      result == service.calculate(command).rows.size()
    where:"We have next cases"
    numberOfPayments || result
    3                || 3
    1                || 1
  }

  void "should detect an invalid number at calculate table size depending on number of payments"() {
    given:"A simulator command"
      def command = new SimulatorCommand()
      command.numberOfPayments = 0
    when:"Input values"
      service.calculate(command)
    then:"We calculate values"
      thrown SimulatorException
  }

  void "should set capital before and after payment"() {
    given:"A simulator command and principle"
      def command = new SimulatorCommand()
      command.numberOfPayments = 3
      command.principle = 35164.88
    when:"We calculate data"
      def result = service.calculate(command)
    then:"We expect same principle with capital before payment"
      result.rows.get(0).capitalBeforePayment == command.principle
      result.rows.get(0).capitalAfterPayment ==  34935.96
      result.rows.get(1).capitalBeforePayment ==  34935.96
      result.rows.get(1).capitalAfterPayment ==   34707.04
      result.rows.get(2).capitalBeforePayment ==  34707.04
      result.rows.get(2).capitalAfterPayment ==   34478.12
  }

  void "should set number depending on numberOfPayments"() {
    given:"A simulator command and principle"
      def command = new SimulatorCommand()
      command.numberOfPayments = 3
      command.principle = 35164.88
    when:"We calculate data"
      def result = service.calculate(command)
    then:"We expect same principle with capital before payment"
      result.rows.get(0).number == 1
      result.rows.get(1).number == 2
      result.rows.get(2).number == 3
  }

  void "should set number dates depending on numberOfPayments"() {
    given:"A simulator command and principle"
      def command = new SimulatorCommand()
      command.numberOfPayments = 2
      command.principle = 35164.88
    when:"We calculate data"
      def result = service.calculate(command)
    then:"We expect same principle with capital before payment"
      result.rows.get(0).paymentDate instanceof Date
      result.rows.get(1).paymentDate instanceof Date
  }

}
