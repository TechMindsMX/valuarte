package com.team.one.service

import spock.lang.Specification
import spock.lang.Unroll

import com.team.one.domain.SimulatorCommand
import com.team.one.service.PMTServiceImpl
import com.team.one.domain.PaymentPeriod
import com.team.one.domain.Paydays
import com.team.one.exception.SimulatorException

class InsuranceServiceSpec extends Specification {

  InsuranceServiceImpl service = new InsuranceServiceImpl()

  @Unroll
  void """When we have a life insurance: #lifeInsurance, loan: #loan: #loan and we want to compute insurance value we expect: #result """() {
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
      31732 | 0             || 31732
  }

  void "should throw an exception when no loan"() {
    given:"A simulator command"
      def command = new SimulatorCommand()
    and: "Input values"
      command.lifeInsurance = 3432.88
    when:"We calculate data"
      def result = service.calculate(command)
    then:"Thrown exception"
      thrown SimulatorException
  }

}
