package com.team.one.service

import com.team.one.service.impl.DatePaymentServiceImpl
import spock.lang.Specification
import com.team.one.domain.Simulator
import com.team.one.domain.PaymentPeriod
import com.team.one.exception.SimulatorException

class DatePaymentServiceSpec extends Specification {

  DatePaymentServiceImpl service = new DatePaymentServiceImpl()

  void "should generate payment dates for a single payment date"() {
    given:"A simulator simulator and principle"
      def simulator = new Simulator()
      simulator.numberOfPayments = 1
      simulator.paymentPeriod = PaymentPeriod.FORTNIGHT
      simulator.startDate = new Date("9/15/2015")
    when:"We calculate data"
      def result = service.generatePaymentDates(simulator)
    then:"We expect same principle with capital before payment"
      result.get(0) == new Date("9/15/2015")
      result.size() == 1
  }

  void "should generate payment dates based in number of payment and start payment date"() {
    given:"A simulator simulator and principle"
      def simulator = new Simulator()
      simulator.numberOfPayments = 2
      simulator.paymentPeriod = PaymentPeriod.FORTNIGHT
      simulator.startDate = new Date("9/15/2015")
    when:"We calculate data"
      def result = service.generatePaymentDates(simulator)
    then:"We expect same principle with capital before payment"
      result.get(0) == new Date("9/15/2015")
      result.get(1) == new Date("9/30/2015")
  }

  void "should generate payment dates based in number of payment and start payment date in four payments"() {
    given:"A simulator simulator and principle"
      def simulator = new Simulator()
      simulator.numberOfPayments = 4
      simulator.paymentPeriod = PaymentPeriod.FORTNIGHT
      simulator.startDate = new Date("9/15/2015")
    when:"We calculate data"
      def result = service.generatePaymentDates(simulator)
    then:"We expect same principle with capital before payment"
      result.get(0) == new Date("9/15/2015")
      result.get(1) == new Date("9/30/2015")
      result.get(2) == new Date("10/15/2015")
      result.get(3) == new Date("10/30/2015")

  }

  void "should generate payment dates based in number of payment and start payment date in four payments at month payment rate"() {
    given:"A simulator simulator and principle"
      def simulator = new Simulator()
      simulator.numberOfPayments = 4
      simulator.paymentPeriod = PaymentPeriod.MONTHLY
      simulator.startDate = new Date("9/30/2015")
    when:"We calculate data"
      def result = service.generatePaymentDates(simulator)
    then:"We expect same principle with capital before payment"
      result.get(0) == new Date("9/30/2015")
      result.get(1) == new Date("10/30/2015")
      result.get(2) == new Date("11/30/2015")
      result.get(3) == new Date("12/30/2015")
  }

  void "should generate payment dates based in number of payment and start payment date in four payments at week payment rate"() {
    given:"A simulator simulator and principle"
      def simulator = new Simulator()
      simulator.numberOfPayments = 4
      simulator.paymentPeriod = PaymentPeriod.WEEKLY
      simulator.startDate = new Date("9/7/2015")
    when:"We calculate data"
      def result = service.generatePaymentDates(simulator)
    then:"We expect same principle with capital before payment"
      result.get(0) == new Date("9/7/2015")
      result.get(1) == new Date("9/14/2015")
      result.get(2) == new Date("9/21/2015")
      result.get(3) == new Date("9/28/2015")
  }

  void "should throw an exception when no payment method"() {
    given:"A simulator simulator and principle"
      def simulator = new Simulator()
      simulator.numberOfPayments = 4
      simulator.startDate = new Date("9/7/2015")
    when:"We calculate data"
      def result = service.generatePaymentDates(simulator)
    then:"Thrown exception"
      thrown SimulatorException
  }

}
