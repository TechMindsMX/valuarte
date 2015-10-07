package com.team.one.service

import spock.lang.Specification
import spock.lang.Unroll

import com.team.one.domain.Simulator
import com.team.one.service.impl.PMTServiceImpl
import com.team.one.domain.PaymentPeriod
import com.team.one.exception.SimulatorException

class PMTServiceSpec extends Specification {

  PMTServiceImpl service = new PMTServiceImpl()

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
      simulator.principle = principle
      simulator.numberOfPayments = numberOfPayments
    then:"We calculate values"
      result == service.calculate(simulator).payment
    where:"We have next cases"
      principle     | tia     |  iva  | numberOfPayments | paymentPeriod            || result
      32267.95      | 40      |  16   | 12               | PaymentPeriod.MONTHLY    || 3411.67
      15000.00      | 40      |  16   | 12               | PaymentPeriod.MONTHLY    || 1585.94
      15000.00      | 40      |  16   | 24               | PaymentPeriod.MONTHLY    || 970.42
      15000.00      | 36      |  16   | 24               | PaymentPeriod.MONTHLY    || 932.13
      32250.79      | 40      |  16   | 12               | PaymentPeriod.FORTNIGHT  || 3037.15
      15000.00      | 40      |  16   | 12               | PaymentPeriod.FORTNIGHT  || 1412.59
      15000.00      | 40      |  16   | 24               | PaymentPeriod.FORTNIGHT  || 787.09
      15000.00      | 36      |  16   | 24               | PaymentPeriod.FORTNIGHT  || 769.90
      32242.04      | 40      |  16   | 12               | PaymentPeriod.WEEKLY     || 2858.64
      15000.00      | 40      |  16   | 12               | PaymentPeriod.WEEKLY     || 1329.93
      15000.00      | 40      |  16   | 24               | PaymentPeriod.WEEKLY     || 703.30
      15000.00      | 36      |  16   | 24               | PaymentPeriod.WEEKLY     || 695.22
  }

  void "should throw an exception when no payment period"() {
    given:"A simulator simulator and principle"
      def simulator = new Simulator()
    and:"Input values"
      simulator.iva = 16
      simulator.tia = 40
      simulator.principle = 15000
      simulator.numberOfPayments = 12
    when:"We calculate data"
      service.calculate(simulator)
    then:"Thrown exception"
      thrown SimulatorException
  }

  @Unroll
  void """when we have tia: #tia and want to calculate we expect Exception"""() {
    given:"A simulator simulator and principle"
      def simulator = new Simulator()
    and:"Input values"
      simulator.iva = 16
      simulator.principle = 15000
      simulator.numberOfPayments = 12
      simulator.paymentPeriod = PaymentPeriod.WEEKLY
      simulator.tia = tia
    when:"We calculate data"
      def result = service.calculate(simulator)
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
      simulator.principle = principle
    when:"We calculate data"
      def result = service.calculate(simulator)
    then:"Thrown exception"
      thrown SimulatorException
    where:"We have next values"
      principle << [null, 0, -1]
  }



}
