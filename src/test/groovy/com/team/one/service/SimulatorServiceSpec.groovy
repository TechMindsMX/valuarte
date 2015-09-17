package com.team.one.service

import spock.lang.Specification
import com.team.one.domain.SimulatorCommand
import com.team.one.service.SimulatorServiceImpl
import com.team.one.domain.PaymentPeriod
import com.team.one.domain.Paydays

class SimulatorServiceSpec extends Specification {

  SimulatorServiceImpl service = new SimulatorServiceImpl()

  void "should calculate tim from tia"() {
    given:"A simulator command"
      def command = new SimulatorCommand()
    when:"We assign values to command"
      command.tia = tia
    then:"We calculate values"
      result == service.calculate(command).tim
    where:"We have next cases"
      tia || result
      40  || 3.33
      30  || 2.50
      50  || 4.17
  }

}
