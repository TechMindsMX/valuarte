package com.team.one.service

import spock.lang.Specification
import spock.lang.Unroll

import com.team.one.domain.Simulator
import com.team.one.service.PPMTServiceImpl
import com.team.one.domain.PaymentPeriod
import com.team.one.exception.SimulatorException

class PPMTServiceSpec extends Specification {

  PPMTServiceImpl service = new PPMTServiceImpl()

  Integer decimals = 2
  String roundingMode = 'HALF_UP'

  def setup(){
    service.decimals = decimals
    service.roundingMode = roundingMode
  }

  @Unroll
  void """When we have iva: #iva, tia: #tia, principle: #principle and number of payments as: #numberOfPayments, payment period: #paymentPeriod and we want calculate payment in a monthly period we expect: #result"""() {
    given:"A simulator"
      def simulator = new Simulator()
    when:"Input values"
      simulator.paymentPeriod = paymentPeriod
      simulator.iva = iva
      simulator.tia = tia
      simulator.numberOfPayments = numberOfPayments
    then:"We calculate values"
      result == service.calculate(simulator, principle, numberPayment)
    where:"We have next cases"
      numberPayment | principle     | tia     |  iva  | numberOfPayments | paymentPeriod            || result
      12            | 31732         | 40      |  16   | 12               | PaymentPeriod.MONTHLY    || 2128.04
      11            | 31732         | 40      |  16   | 12               | PaymentPeriod.MONTHLY    || 2210.32
      10            | 31732         | 40      |  16   | 12               | PaymentPeriod.MONTHLY    || 2295.79
      9             | 31732         | 40      |  16   | 12               | PaymentPeriod.MONTHLY    || 2384.56
      8             | 31732         | 40      |  16   | 12               | PaymentPeriod.MONTHLY    || 2476.76
  }

  void "should throw an exception when no payment period"() {
    given:"A simulator simulator and principle"
      def simulator = new Simulator()
    and:"Input values"
      simulator.iva = 16
      simulator.tia = 40
      simulator.numberOfPayments = 12
      def numberPayment = 12
      def principle = 15000
    when:"We calculate data"
      service.calculate(simulator, principle, numberPayment)
    then:"Thrown exception"
      thrown SimulatorException
  }

  @Unroll
  void """when we have tia: #tia and want to calculate we expect Exception"""() {
    given:"A simulator simulator and principle"
      def simulator = new Simulator()
    and:"Input values"
      simulator.iva = 16
      simulator.numberOfPayments = 12
      simulator.paymentPeriod = PaymentPeriod.WEEKLY
      simulator.tia = tia
      def numberPayment = 12
      def principle = 15000
    when:"We calculate data"
      def result = service.calculate(simulator, principle, numberPayment)
    then:"Thrown exception"
      thrown SimulatorException
    where:"We have next values"
      tia << [null, 0, -1]
  }

  @Unroll
  void """when we have principle: #principle and want to calculate we expect Exception"""() {
    given:"A simulator simulator and principle"
      def simulator = new Simulator()
    and:"Input values"
      simulator.iva = 16
      simulator.tia = 40
      simulator.numberOfPayments = 12
      simulator.paymentPeriod = PaymentPeriod.WEEKLY
      def numberPayment = 12
    when:"We calculate data"
      def result = service.calculate(simulator, principle, numberPayment)
    then:"Thrown exception"
      thrown SimulatorException
    where:"We have next values"
      principle << [null, 0, -1]
  }


}
