package com.team.one.service

import spock.lang.Specification
import com.team.one.domain.PaymentPeriod
import com.team.one.domain.SimulatorCommand

class InterestServiceSpec extends Specification {

  InterestServiceImpl service = new InterestServiceImpl()

  void "should calculate interest based in capital before payment and a monthly payment period"() {
    given:"A simulator command"
      def command = new SimulatorCommand()
    when:"We assign payment period and tia"
      command.tia = tia
      command.paymentPeriod
    then:"We calculate values based on payment period"
      result == service.calculate(capitalBeforePayment, command)
    where:"We have next cases"
      capitalBeforePayment  | tia    | paymentPeriod            || result
      null                  | 40     | PaymentPeriod.MONTHLY    || 0
      null                  | 40     | PaymentPeriod.WEEKLY     || 0
      null                  | 40     | PaymentPeriod.FORTNIGHT  || 0
      35676.36              | null   | PaymentPeriod.MONTHLY    || 0
      35676.36              | null   | PaymentPeriod.WEEKLY     || 0
      35676.36              | null   | PaymentPeriod.FORTNIGHT  || 0
      35676.36              | 40     | PaymentPeriod.MONTHLY    || 1189.21
  }

}
