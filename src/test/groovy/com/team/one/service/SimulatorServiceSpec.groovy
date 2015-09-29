package com.team.one.service

import spock.lang.Specification
import spock.lang.Unroll

import com.team.one.domain.SimulatorCommand
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

  @Unroll
  void """When we have an payment period: #paymentPeriod we expect paydays: #result"""() {
    given:"A simulator command"
      def command = new SimulatorCommand()
    when:"We assign values to command"
      command.paymentPeriod = paymentPeriod
    then:"We calculate values"
      result == service.calculate(command).paydays
    where:"We have next cases"
      paymentPeriod           || result
      PaymentPeriod.WEEKLY    || '7,15,21,30'
      PaymentPeriod.FORTNIGHT || '15,30'
      PaymentPeriod.MONTHLY   || '30'
  }

  void "should send an exception if no paymentPeriod"() {
    given:"A simulator command"
      def command = new SimulatorCommand()
    when:"We calculate values"
      service.calculate(command)
    then:"We expect an exception"
      thrown SimulatorException
  }

}
