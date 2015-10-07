package com.team.one.service

import com.team.one.service.impl.InsuranceServiceImpl
import spock.lang.Specification
import spock.lang.Unroll

import com.team.one.domain.Simulator
import com.team.one.exception.SimulatorException

class InsuranceServiceSpec extends Specification {

  InsuranceServiceImpl service = new InsuranceServiceImpl()

  @Unroll
  void """When we have a life insurance: #lifeInsurance, loan: #loan: #loan and we want to compute insurance value we expect: #result """() {
    given:"A simulator simulator"
      def simulator = new Simulator()
    when:"Input values"
      simulator.lifeInsurance = lifeInsurance
      simulator.loan = loan
    then:"We calculate values"
      result == service.calculate(simulator).principle
    where:"We have next cases"
      loan  | lifeInsurance || result
      31732 | 3432.88       || 35164.88
      31732 | 0             || 31732
  }

  void "should throw an exception when no loan"() {
    given:"A simulator simulator"
      def simulator = new Simulator()
    and: "Input values"
      simulator.lifeInsurance = 3432.88
    when:"We calculate data"
      def result = service.calculate(simulator)
    then:"Thrown exception"
      thrown SimulatorException
  }

}
