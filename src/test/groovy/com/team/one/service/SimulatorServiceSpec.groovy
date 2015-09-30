package com.team.one.service

import spock.lang.Specification
import spock.lang.Unroll

import com.team.one.domain.Simulator
import com.team.one.service.SimulatorServiceImpl
import com.team.one.service.PMTService
import com.team.one.domain.PaymentPeriod
import com.team.one.exception.SimulatorException

class SimulatorServiceSpec extends Specification {

  SimulatorServiceImpl service = new SimulatorServiceImpl()

  def pmtService = Mock(PMTService)

  def setup(){
    service.pmtService = pmtService
  }

  void "should call pmt calculation service"() {
    given:"A simulator simulator"
      def simulator = new Simulator()
      simulator.paymentPeriod = PaymentPeriod.WEEKLY
    when:"We assign values to simulator"
      service.calculate(simulator)
    then:"We calculate values"
      1 * pmtService.calculate(simulator)
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
