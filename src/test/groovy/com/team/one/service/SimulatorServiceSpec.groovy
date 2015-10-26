package com.team.one.service

import spock.lang.Specification
import com.team.one.service.impl.SimulatorServiceImpl
import com.team.one.command.SeguroMedicoCommand
import com.team.one.domain.Simulator
import com.team.one.repository.SimulatorRepository
import com.team.one.exception.SimulatorException

class SimulatorServiceSpec extends Specification {

  SimulatorServiceImpl service = new SimulatorServiceImpl()

  def simulatorRepository = Mock(SimulatorRepository)

  def setup(){
    service.simulatorRepository = simulatorRepository
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

  void "should save simulator"(){
    given:"An simulator"
      def simulator = new Simulator(rfc:'MOCS801001ABC')
    when:"We tryed to save"
      service.save(simulator)
    then:"We expect repository saves"
      1 * simulatorRepository.save(simulator)
  }

  void "should not save simulator"(){
    given:"An simulator"
      def simulator = new Simulator()
    when:"We tryed to save"
      service.save(simulator)
    then:"We expect an exception"
      thrown SimulatorException
  }

}
