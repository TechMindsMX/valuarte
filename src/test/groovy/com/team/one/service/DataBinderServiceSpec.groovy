package com.team.one.service

import spock.lang.Specification
import com.team.one.domain.Simulator
import com.team.one.domain.SimulatorCommand
import com.team.one.domain.Client
import com.team.one.domain.PaymentPeriod

class DataBinderServiceSpec extends Specification {

  DataBinderServiceImpl service = new DataBinderServiceImpl()

  void "Should get Simulator from simulatorCommand"(){
    given:"An simulator command"
      def command = new SimulatorCommand()
      command.tia = 40
      command.iva = 16
      command.openingCommission = 0
      command.payment = 800
      command.loan = 15000
      command.principle = 18000
      command.lifeInsurance = 0
      command.paymentPeriod = PaymentPeriod.WEEKLY
      command.numberOfPayments = 12
      command.startDate = new Date()
    when:"We bind command"
      def simulator = service.bindSimulator(command)
    then:"We Expect simulator"
      simulator.tia == 40
      simulator.iva == 16
      simulator.openingCommission == 0
      simulator.payment == 800
      simulator.loan == 15000
      simulator.principle == 18000
      simulator.lifeInsurance == 0
      simulator.paymentPeriod == PaymentPeriod.WEEKLY
      simulator.numberOfPayments == 12
      simulator.startDate instanceof Date
  }

  void "should get Client from SimulatorCommand"(){
    given: "A simulator command"
      def command = new SimulatorCommand()
      command.rfc = "rfc"
      command.firstName = "firstName"
      command.lastName = "lastName"
    when:"We bind command"
      def client = service.bindClient(command)
    then:"We expect client data"
      client.rfc == "rfc"
      client.firstName == "firstName"
      client.lastName == "lastName"
  }

}

