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
  void """When we have iva: #iva, tia: #tia, principle: #principle and number of payments as: #numberOfPayments and we want calculate payment in a monthly period we expect: #result"""() {
    given:"A simulator command"
      def command = new SimulatorCommand()
    when:"Input values"
      command.paymentPeriod = PaymentPeriod.MONTHLY
      command.iva = iva
      command.tia = tia
      command.loan = principle
      command.numberOfPayments = numberOfPayments
    then:"We calculate values"
      result == service.calculate(command).payment
    where:"We have next cases"
      principle     | tia     |  iva  | numberOfPayments || result
      32267.95      | 40      |  16   | 12               || 3411.67
      15000.00      | 40      |  16   | 12               || 1585.94
      15000.00      | 40      |  16   | 24               || 970.42
      15000.00      | 36      |  16   | 24               || 932.13
  }

}
