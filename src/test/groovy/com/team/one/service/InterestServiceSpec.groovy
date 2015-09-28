package com.team.one.service

import spock.lang.Specification
import spock.lang.Unroll

import com.team.one.domain.PaymentPeriod
import com.team.one.domain.SimulatorCommand

class InterestServiceSpec extends Specification {

  InterestServiceImpl service = new InterestServiceImpl()

  @Unroll
  void """When we have a tia: #tia, payment period: #paymentPeriod, and  capital before payment: #capitalBeforePayment calculating result we we expect: #result"""() {
    given:"A simulator command"
      def command = new SimulatorCommand()
    when:"We assign payment period and tia"
      command.tia = tia
      command.paymentPeriod = paymentPeriod
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
      34665.00              | 40     | PaymentPeriod.MONTHLY    || 1155.50
      35164.88              | 40     | PaymentPeriod.FORTNIGHT  || 586.08
      30919.94              | 40     | PaymentPeriod.FORTNIGHT  || 515.33
      34864.33              | 40     | PaymentPeriod.WEEKLY     || 290.54
      29057.15              | 40     | PaymentPeriod.WEEKLY     || 242.14
  }

}
