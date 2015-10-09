package com.team.one.service

import com.team.one.service.impl.InsuranceServiceImpl
import spock.lang.Specification
import com.team.one.domain.Simulator
import com.team.one.exception.SimulatorException

class InsuranceServiceSpec extends Specification {

  InsuranceServiceImpl service = new InsuranceServiceImpl()

  def insuranceDataService = Mock(InsuranceDataService)

  def setup(){
    service.insuranceDataService = insuranceDataService
    insuranceDataService.calculate(_) >> [100,200]
  }

  void "Should get life insurance value"() {
    given:"A simulator simulator"
      def simulator = new Simulator()
      simulator.loan = 50
    when:"Calculate values"
      def result = service.calculate(simulator)
    then:"We expect sum"
      result == 300
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
