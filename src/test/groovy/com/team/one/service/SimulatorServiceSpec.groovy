package com.team.one.service

import spock.lang.Specification
import com.team.one.domain.Simulator
import com.team.one.service.impl.SimulatorServiceImpl
import com.team.one.domain.PaymentPeriod
import com.team.one.domain.enums.SimulatorType
import com.team.one.exception.SimulatorException
import com.team.one.command.SeguroMedicoCommand


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
      simulator.loan = 2000
      simulator.paymentPeriod = PaymentPeriod.WEEKLY
    when:"We assign values to simulator"
      def result = service.calculate(simulator)
    then:"We calculate values"
      1 * pmtService.calculate(_ as Simulator)
      result.principle == 2120
  }

  void "should send an exception if no paymentPeriod"() {
    given:"A simulator simulator"
      def simulator = new Simulator()
    when:"We calculate values"
      service.calculate(simulator)
    then:"We expect an exception"
      thrown SimulatorException
  }

  void "get the cost of health insurance"() {
    given: "create a seguroMedicoCommand"
      def command = new SeguroMedicoCommand(edad:edad)
    when:
      def result  = service.getCostOfHealthInsurance(command)
    then:
      result == value
    where:
    edad || value
     2   ||  1
     16  ||  1
     25  || 25
     39  || 39
     10  ||  1
  }

}
