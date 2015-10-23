package com.team.one.service

import spock.lang.Specification
import com.team.one.service.impl.SimulatorServiceImpl
import com.team.one.command.SeguroMedicoCommand

class SimulatorServiceSpec extends Specification {

  SimulatorServiceImpl service = new SimulatorServiceImpl()

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
