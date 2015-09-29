package com.team.one.service

import spock.lang.Specification
import com.team.one.domain.SimulatorCommand
import com.team.one.service.SimulatorDataServiceImpl
import com.team.one.domain.PaymentPeriod
import com.team.one.exception.SimulatorException

class DatePaymentServiceSpec extends Specification {

  DatePaymentServiceImpl service = new DatePaymentServiceImpl()

  void "should generate payment dates for a single payment date"() {
    given:"A simulator command and principle"
      def command = new SimulatorCommand()
      command.numberOfPayments = 1
      command.paymentPeriod = PaymentPeriod.FORTNIGHT
      command.startDate = new Date("9/15/2015")
    when:"We calculate data"
      def result = service.generatePaymentDates(command)
    then:"We expect same principle with capital before payment"
      result.get(0) == new Date("9/15/2015")
      result.size() == 1
  }

  void "should generate payment dates based in number of payment and start payment date"() {
    given:"A simulator command and principle"
      def command = new SimulatorCommand()
      command.numberOfPayments = 2
      command.paymentPeriod = PaymentPeriod.FORTNIGHT
      command.startDate = new Date("9/15/2015")
    when:"We calculate data"
      def result = service.generatePaymentDates(command)
    then:"We expect same principle with capital before payment"
      result.get(0) == new Date("9/15/2015")
      result.get(1) == new Date("9/30/2015")
  }

  void "should generate payment dates based in number of payment and start payment date in four payments"() {
    given:"A simulator command and principle"
      def command = new SimulatorCommand()
      command.numberOfPayments = 4
      command.paymentPeriod = PaymentPeriod.FORTNIGHT
      command.startDate = new Date("9/15/2015")
    when:"We calculate data"
      def result = service.generatePaymentDates(command)
    then:"We expect same principle with capital before payment"
      result.get(0) == new Date("9/15/2015")
      result.get(1) == new Date("9/30/2015")
      result.get(2) == new Date("10/15/2015")
      result.get(3) == new Date("10/30/2015")

  }

  void "should generate payment dates based in number of payment and start payment date in four payments at month payment rate"() {
    given:"A simulator command and principle"
      def command = new SimulatorCommand()
      command.numberOfPayments = 4
      command.paymentPeriod = PaymentPeriod.MONTHLY
      command.startDate = new Date("9/30/2015")
    when:"We calculate data"
      def result = service.generatePaymentDates(command)
    then:"We expect same principle with capital before payment"
      result.get(0) == new Date("9/30/2015")
      result.get(1) == new Date("10/30/2015")
      result.get(2) == new Date("11/30/2015")
      result.get(3) == new Date("12/30/2015")
  }

  void "should generate payment dates based in number of payment and start payment date in four payments at week payment rate"() {
    given:"A simulator command and principle"
      def command = new SimulatorCommand()
      command.numberOfPayments = 4
      command.paymentPeriod = PaymentPeriod.WEEKLY
      command.startDate = new Date("9/7/2015")
    when:"We calculate data"
      def result = service.generatePaymentDates(command)
    then:"We expect same principle with capital before payment"
      result.get(0) == new Date("9/7/2015")
      result.get(1) == new Date("9/14/2015")
      result.get(2) == new Date("9/21/2015")
      result.get(3) == new Date("9/28/2015")
  }

  void "should throw an exception when no payment method"() {
    given:"A simulator command and principle"
      def command = new SimulatorCommand()
      command.numberOfPayments = 4
      command.startDate = new Date("9/7/2015")
    when:"We calculate data"
      def result = service.generatePaymentDates(command)
    then:"Thrown exception"
      thrown SimulatorException
  }

}
