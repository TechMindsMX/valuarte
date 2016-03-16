package com.team.one.collaborator

import spock.lang.Specification
import com.team.one.domain.Simulator
import com.team.one.collaborator.SimulatorCollaborator
import com.team.one.domain.PaymentPeriod
import com.team.one.domain.enums.SimulatorType
import com.team.one.service.PMTService
import com.team.one.service.InsuranceService
import com.team.one.service.OpeningCommissionService
import com.team.one.exception.SimulatorException

class SimulatorCollaboratorSpec extends Specification {

  SimulatorCollaborator collaborator = new SimulatorCollaborator()

  def pmtService = Mock(PMTService)
  def insuranceService = Mock(InsuranceService)
  def openingCommissionService = Mock(OpeningCommissionService)

  def setup(){
    collaborator.pmtService = pmtService
    collaborator.insuranceService = insuranceService
    collaborator.openingCommissionService = openingCommissionService

    insuranceService.calculate(_) >> 100
    openingCommissionService.calculate(_) >> 20
  }

  void "should call pmt calculation service"() {
    given:"A simulator simulator"
      def simulator = new Simulator()
      simulator.loan = 2000
      simulator.paymentPeriod = PaymentPeriod.WEEKLY
    when:"We assign values to simulator"
      def result = collaborator.calculate(simulator)
    then:"We calculate values"
      1 * pmtService.calculate(_ as Simulator)
      result.principle == 2120
  }

  void "should send an exception if no paymentPeriod"() {
    given:"A simulator simulator"
      def simulator = new Simulator()
    when:"We calculate values"
      collaborator.calculate(simulator)
    then:"We expect an exception"
      thrown SimulatorException
  }
}
