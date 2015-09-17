package com.team.one.service

import spock.lang.Specification
import com.team.one.domain.SimulatorCommand
import com.team.one.service.SimulatorServiceImpl

class SimulatorServiceSpec extends Specification {

  SimulatorServiceImpl service = new SimulatorServiceImpl()

  void "should calculate tim from tia"() {
    given:"A simulator command"
      def command = new SimulatorCommand()
      command.tia = 40
    when:"We calculate tim"
      def result = service.calculate(command)
      println result.dump()
    then:
      result.tim == 3.33
  }

}
