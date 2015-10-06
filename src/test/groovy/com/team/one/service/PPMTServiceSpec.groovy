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
      simulator.principle = principle
      simulator.numberOfPayments = numberOfPayments
    then:"We calculate values"
      result == service.calculate(simulator, numberPayment)
    where:"We have next cases"
      numberPayment | principle     | tia     |  iva  | numberOfPayments | paymentPeriod            || result
      12            | 31732         | 40      |  16   | 12               | PaymentPeriod.MONTHLY    || 2128.04
  }

}
