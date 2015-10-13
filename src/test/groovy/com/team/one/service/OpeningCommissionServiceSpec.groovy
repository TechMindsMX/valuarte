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
  void """When we have an loan: #loan, openingCommission: #openingCommission, iva: #iva and we want to compute principle we expect: result: #result"""() {
    given:"A simulator"
      def simulator = new Simulator()
    when:"We have this values"
      simulator.loan = loan
      simulator.openingCommission = openingCommission
      simulator.iva = iva
    then:"We calculate values"
      result == service.calculate(simulator)
    where:"We have next cases"
    loan   | openingCommission | iva || result
    31732  | 2                 | 16  || 32485.67
    100000 | 2                 | 16  || 102375.10
    31732  | 10                | 16  || 35895.93
    31732  | 2                 | 15  || 32479.02
    31732  | 0                 | 16  || 31732
    31732  | 0                 | 0   || 31732
  }

}
