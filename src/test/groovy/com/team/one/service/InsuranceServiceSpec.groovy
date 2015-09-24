package com.team.one.service

import spock.lang.Specification
import com.team.one.domain.SimulatorCommand
import com.team.one.service.PMTServiceImpl
import com.team.one.domain.PaymentPeriod
import com.team.one.domain.Paydays
import com.team.one.exception.SimulatorException

class InsuranceServiceSpec extends Specification {

  InsuranceServiceImpl service = new InsuranceServiceImpl()

  void "should calculate principle"() {
    given:"A simulator command"
      def command = new SimulatorCommand()
    when:"Input values"
      command.lifeInsurance = lifeInsurance
      command.loan = loan
    then:"We calculate values"
      result == service.calculate(command).principle
    where:"We have next cases"
      loan  | lifeInsurance || result
      31732 | 3432.88       || 35164.88
  }

}
