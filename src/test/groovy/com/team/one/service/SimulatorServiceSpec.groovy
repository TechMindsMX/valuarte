package com.team.one.service

import spock.lang.Specification
import com.team.one.domain.Simulator
import com.team.one.service.impl.SimulatorServiceImpl
import com.team.one.domain.PaymentPeriod
import com.team.one.exception.SimulatorException

class SimulatorServiceSpec extends Specification {

  SimulatorServiceImpl service = new SimulatorServiceImpl()

  def pmtService = Mock(PMTService)
  def insuranceService = Mock(InsuranceService)
  def openingCommissionService = Mock(OpeningCommissionService)

  def setup(){
    service.pmtService = pmtService
    service.insuranceService = insuranceService
    service.openingCommissionService = openingCommissionService

    insuranceService.calculate(_) >> 100
    openingCommissionService.calculate(_) >> 20
  }

  void "should call pmt calculation service"() {
    given:"A simulator simulator"
      def simulator = new Simulator()
      simulator.loan = 100
      simulator.paymentPeriod = PaymentPeriod.WEEKLY
    when:"We assign values to simulator"
      service.calculate(simulator)
    then:"We calculate values"
      1 * pmtService.calculate(simulator)
      simulator.lifeInsurance == 100
      simulator.principle == 220
  }

  void "should send an exception if no paymentPeriod"() {
    given:"A simulator simulator"
      def simulator = new Simulator()
    when:"We calculate values"
      service.calculate(simulator)
    then:"We expect an exception"
      thrown SimulatorException
  }

}
