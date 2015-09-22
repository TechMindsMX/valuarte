package com.team.one.service

import spock.lang.Specification
import com.team.one.domain.SimulatorCommand
import com.team.one.service.PMTServiceImpl
import com.team.one.domain.PaymentPeriod
import com.team.one.domain.Paydays
import com.team.one.exception.SimulatorException

class PMTServiceSpec extends Specification {

  PMTServiceImpl service = new PMTServiceImpl()

  void "should calculate payment in a monthly payment period"() {
    given:"A simulator command"
      def command = new SimulatorCommand()
    when:"Input values"
      command.paymentPeriod = PaymentPeriod.MONTHLY
      command.iva = iva
      command.tim = tim
      command.loan = loan
    then:"We calculate values"
      result == service.calculate(command).payment
    where:"We have next cases"
      loan  | tim     |  iva  || result
      31733 | 3.33    |  16   || 88.059075
  }

}
