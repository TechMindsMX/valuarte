package com.team.one.service

import spock.lang.Specification
import spock.lang.Unroll

import com.team.one.domain.Simulator
import com.team.one.service.impl.InsuranceDataServiceImpl
import com.team.one.exception.SimulatorException

class InsuranceDataServiceSpec extends Specification {

  InsuranceDataServiceImpl service = new InsuranceDataServiceImpl()

  Integer decimals = 2
  String roundingMode = 'HALF_UP'

  def ppmtService = Mock(PPMTService)

  def setup(){
    service.ppmtService = ppmtService
    ppmtService.calculate(_, _, _) >> 2128.04 >> 2210.32 >> 2295.79 >> 2384.56 >> 2476.76

    service.decimals = decimals
    service.roundingMode = roundingMode
  }

  @Unroll
  void """given number of payments as: #numberOfPayments we expect thown exception"""() {
    given:"A simulator"
      def simulator = new Simulator()
      simulator.numberOfPayments = numberOfPayments
    when:"Input values"
      service.calculate(simulator)
    then:"We calculate values"
      thrown SimulatorException
    where:"We have next cases"
      numberOfPayments << [null, 0, -1]
  }

  void "should set capital before and after payment"() {
    given:"A simulator and principle"
      def simulator = new Simulator()
      simulator.numberOfPayments = 12
      simulator.loan = 31732
      simulator.openingCommission = 753.67
      simulator.iva = 16
    when:"We calculate data"
      def result = service.calculate(simulator)
    then:"We expect same principle with capital before payment"
      result.get(0) ==  78.94
      result.get(1) ==  73.77
      result.get(2) ==  68.40
      result.get(3) ==  62.82
      result.get(4) ==  57.02
      result.size() ==  12
  }

}
