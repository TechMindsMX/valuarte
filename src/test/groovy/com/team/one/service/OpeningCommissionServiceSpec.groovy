package com.team.one.service

import com.team.one.service.impl.OpeningCommissionServiceImpl
import spock.lang.Specification
import spock.lang.Unroll
import com.team.one.domain.Simulator
import com.team.one.exception.SimulatorException

class OpeningCommissionServiceSpec extends Specification {

  OpeningCommissionServiceImpl service = new OpeningCommissionServiceImpl()

  Integer decimals = 2
  String roundingMode = 'HALF_UP'

  def setup(){
    service.decimals = decimals
    service.roundingMode = roundingMode
  }

  @Unroll
  void """When we have an loan: #loan, commission: #commission, iva: #iva and we want to compute principle we expect: result: #result"""() {
    given:"A simulator"
      def simulator = new Simulator()
    when:"We have this values"
      simulator.loan = loan
      simulator.iva = iva
      simulator.commission = commission
    then:"We calculate values"
      result == service.calculate(simulator)
    where:"We have next cases"
    loan   | commission | iva || result
    31732  | 2          | 16  || 753.67
    100000 | 2          | 16  || 2375.10
    31732  | 10         | 16  || 4163.93
    31732  | 2          | 15  || 747.02
    31732  | 0          | 16  || 0
    31732  | 0          | 0   || 0
  }

  void "should throw an exception when no loan"() {
    given:"A simulator"
      def simulator = new Simulator()
    and:"Input values"
      simulator.iva = 16
      simulator.commission = 2
    when:"We calculate data"
      service.calculate(simulator)
    then:"Thrown exception"
      thrown SimulatorException
  }

}
