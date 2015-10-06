package com.team.one.service

import spock.lang.Specification
import spock.lang.Unroll

import com.team.one.domain.Simulator
import com.team.one.service.PMTServiceImpl
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
      result == service.calculate(simulator)
    where:"We have next cases"
      principle     | tia     |  iva  | numberOfPayments | paymentPeriod            || result
      32267.95      | 40      |  16   | 12               | PaymentPeriod.MONTHLY    || 2128.04
  }

}
