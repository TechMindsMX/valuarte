package com.team.one.service

import spock.lang.Specification
import com.team.one.domain.PaymentPeriod
import com.team.one.domain.SimulatorCommand

class InterestServiceSpec extends Specification {

  InterestServiceImpl service = new InterestServiceImpl()

  void "should calculate interest based in capital and a monthly payment period"() {
    given:"A simulator command"
      def command = new SimulatorCommand()
    when:"We assign payment period and tim"
      command.tim = tim
      command.paymentPeriod
    then:"We calculate values based on payment period"
      result == service.calculate(capital, command)
    where:"We have next cases"
      capital  | tim      | paymentPeriod            || result
      null     | 3.33     | PaymentPeriod.MONTHLY    || 0
      null     | 3.33     | PaymentPeriod.WEEKLY     || 0
      null     | 3.33     | PaymentPeriod.FORTNIGHT  || 0
      228.92   | null     | PaymentPeriod.MONTHLY    || 0
      228.92   | null     | PaymentPeriod.WEEKLY     || 0
      228.92   | null     | PaymentPeriod.FORTNIGHT  || 0
  }

}
