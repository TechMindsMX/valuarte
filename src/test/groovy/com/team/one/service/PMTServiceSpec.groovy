package com.team.one.service

import spock.lang.Specification
import spock.lang.Unroll

import com.team.one.domain.SimulatorCommand
import com.team.one.service.PMTServiceImpl
import com.team.one.domain.PaymentPeriod
import com.team.one.exception.SimulatorException

class PMTServiceSpec extends Specification {

  PMTServiceImpl service = new PMTServiceImpl()

  @Unroll
  void """When we have iva: #iva, tia: #tia, principle: #principle and number of payments as: #numberOfPayments, payment period: #paymentPeriod and we want calculate payment in a monthly period we expect: #result"""() {
    given:"A simulator command"
      def command = new SimulatorCommand()
    when:"Input values"
      command.paymentPeriod = paymentPeriod
      command.iva = iva
      command.tia = tia
      command.loan = principle
      command.numberOfPayments = numberOfPayments
    then:"We calculate values"
      result == service.calculate(command).payment
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
    given:"A simulator command and principle"
      def command = new SimulatorCommand()
    and:"Input values"
      command.iva = 16
      command.tia = 40
      command.principle = 15000
      command.numberOfPayments = 12
    when:"We calculate data"
      service.calculate(command).payment
    then:"Thrown exception"
      thrown SimulatorException
  }

}
