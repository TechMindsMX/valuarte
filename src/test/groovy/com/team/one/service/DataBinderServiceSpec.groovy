package com.team.one.service

import spock.lang.Specification
import com.team.one.domain.SimulatorCommand
import com.team.one.domain.Simulator

class DataBinderServiceSpec extends Specification {

  DataBinderServiceImpl service = new DataBinderServiceImpl()

  void "Should get Simulator from SimulatorCommand"(){
    given:"An simulator command"
      def command = new SimulatorCommand()
    when:"We bind command"
      def simulator = service.bind(command)
    then:"We Expect simulator"
      simulator instanceof Simulator
  }

}

