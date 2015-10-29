package com.team.one.service

import spock.lang.Specification
import com.team.one.service.impl.SimulatorServiceImpl
import com.team.one.command.SeguroMedicoCommand
import com.team.one.domain.Simulator
import com.team.one.repository.SimulatorRepository
import com.team.one.repository.CostHealthInsurenceRepository
import com.team.one.exception.SimulatorException
import com.team.one.domain.CostHealthInsurence

class SimulatorServiceSpec extends Specification {

  SimulatorServiceImpl service = new SimulatorServiceImpl()

  def simulatorRepository = Mock(SimulatorRepository)
  def costRepository = Mock(CostHealthInsurenceRepository)


  def setup(){
    service.simulatorRepository = simulatorRepository
    service.costRepository = costRepository
  }

  void "get the cost of health insurance"() {
    given: "create a seguroMedicoCommand"
      def command = new SeguroMedicoCommand(
                        age:edad,
                        optionsPack:optionsRadios,
                        sex:sex)
    and:
      def costHealth = new CostHealthInsurence(cost:cost)
    when:
      costRepository.findByOptionPackAndSexAndAge(optionsRadios,sex,edad) >> costHealth
      def result  = service.getCostOfHealthInsurance(command)
    then:
      result == value
    where:
    optionsRadios |  sex     | edad | cost     || value
    "option1"     | "male"   |  1   | 1000.00  ||  1000.00
    "option2"     | "female" |  1   | 1001.00  ||  1001.00
    "option3"     | "female" |  25  | 1003.00  ||  1003.00
    "option4"     | "male"   |  1   | 1002.00  ||  1002.00
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
