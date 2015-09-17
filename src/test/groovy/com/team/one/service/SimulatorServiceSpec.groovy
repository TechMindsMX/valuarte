package com.team.one.service

import spock.lang.Specification
import com.team.one.domain.SimulatorCommand
import com.team.one.service.SimulatorServiceImpl
import com.team.one.domain.PaymentPeriod
import com.team.one.domain.Paydays
import com.team.one.exception.SimulatorException

class SimulatorServiceSpec extends Specification {

  SimulatorServiceImpl service = new SimulatorServiceImpl()

  void "should calculate tim from tia"() {
    given:"A simulator command"
      def command = new SimulatorCommand()
      command.paymentPeriod = PaymentPeriod.WEEKLY
    when:"We assign values to command"
      command.tia = tia
    then:"We calculate values"
      result == service.calculate(command).tim
    where:"We have next cases"
      tia   || result
      40    || 3.33
      30    || 2.50
      50    || 4.17
      0.00  || 0.00
      null  || 0.00
  }

  void "should calculate paydays from paymentPeriod"() {
    given:"A simulator command"
      def command = new SimulatorCommand()
    when:"We assign values to command"
      command.paymentPeriod = paymentPeriod
    then:"We calculate values"
      result == service.calculate(command).paymentPeriod
    where:"We have next cases"
      paymentPeriod           || result
      PaymentPeriod.WEEKLY    || PaymentPeriod.WEEKLY
      PaymentPeriod.FORTNIGHT || PaymentPeriod.FORTNIGHT
      PaymentPeriod.MONTHLY   || PaymentPeriod.MONTHLY
  }

  void "should send an exception if no paymentPeriod"() {
    given:"A simulator command"
      def command = new SimulatorCommand()
    when:"We calculate values"
      service.calculate(command)
    then:"We expect an exception"
      thrown SimulatorException
  }

}
