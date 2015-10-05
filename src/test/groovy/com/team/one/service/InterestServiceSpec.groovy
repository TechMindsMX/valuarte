package com.team.one.service

import spock.lang.Specification
import spock.lang.Unroll

import com.team.one.domain.PaymentPeriod
import com.team.one.domain.Simulator
import com.team.one.exception.SimulatorException

class InterestServiceSpec extends Specification {

  InterestServiceImpl service = new InterestServiceImpl()

  Integer decimals = 2
  String roundingMode = 'HALF_UP'

  def setup(){
    service.decimals = decimals
    service.roundingMode = roundingMode
  }

  @Unroll
  void """When we have a tia: #tia, payment period: #paymentPeriod, and  capital before payment: #capitalBeforePayment calculating result we we expect: #result"""() {
    given:"A simulator simulator"
      def simulator = new Simulator()
    when:"We assign payment period and tia"
      simulator.tia = tia
      simulator.paymentPeriod = paymentPeriod
    then:"We calculate values based on payment period"
      result == service.calculate(capitalBeforePayment, simulator)
    where:"We have next cases"
      capitalBeforePayment  | tia    | paymentPeriod            || result
      35676.36              | 40     | PaymentPeriod.MONTHLY    || 1189.21
      34665.00              | 40     | PaymentPeriod.MONTHLY    || 1155.50
      35164.88              | 40     | PaymentPeriod.FORTNIGHT  || 586.08
      30919.94              | 40     | PaymentPeriod.FORTNIGHT  || 515.33
      34864.33              | 40     | PaymentPeriod.WEEKLY     || 290.54
      29057.15              | 40     | PaymentPeriod.WEEKLY     || 242.14
      35585.00              | 36     | PaymentPeriod.MONTHLY    || 1067.55
      33549.53              | 36     | PaymentPeriod.MONTHLY    || 1006.49
      35106.73              | 36     | PaymentPeriod.FORTNIGHT  || 526.60
      30896.74              | 36     | PaymentPeriod.FORTNIGHT  || 463.45
      34833.11              | 36     | PaymentPeriod.WEEKLY     || 261.25
      28044.50              | 36     | PaymentPeriod.WEEKLY     || 210.33
  }

  void "should throw an exception when no tia"() {
    given:"A simulator simulator and principle"
      def simulator = new Simulator()
      simulator.tia = tia
    and: "Capital before payment"
      def capitalBeforePayment = 35676.36
    when:"We calculate data"
      def result = service.calculate(capitalBeforePayment, simulator)
    then:"Thrown exception"
      thrown SimulatorException
    where:"We have next values"
      tia << [null, 0, -1]
  }

  void "should throw an exception when no capitalBeforePayment"() {
    given:"A simulator simulator and principle"
      def simulator = new Simulator()
      simulator.tia = 40
    and: "Capital before payment"
      capitalBeforePayment = capitalBeforePayment
    when:"We calculate data"
      def result = service.calculate(capitalBeforePayment, simulator)
    then:"Thrown exception"
      thrown SimulatorException
    where:"We have next values"
      capitalBeforePayment << [null, 0, -1]
  }


  void "should throw an exception when no payment period"() {
    given:"A simulator simulator and principle"
      def simulator = new Simulator()
      simulator.tia = 40
    and: "Capital before payment"
      def capitalBeforePayment = 35676.36
    when:"We calculate data"
      def result = service.calculate(capitalBeforePayment, simulator)
    then:"Thrown exception"
      thrown SimulatorException
  }

}
