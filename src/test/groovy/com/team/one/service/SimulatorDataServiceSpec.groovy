package com.team.one.service

import spock.lang.Specification
import com.team.one.domain.SimulatorCommand
import com.team.one.service.PMTServiceImpl
import com.team.one.domain.PaymentPeriod
import com.team.one.domain.Paydays
import com.team.one.exception.SimulatorException

class SimulatorDataServiceSpec extends Specification {

  SimulatorDataServiceImpl service = new SimulatorDataServiceImpl()

  void "should calculate table size depending on number of payments"() {
    given:"A simulator command"
      def command = new SimulatorCommand()
    when:"Input values"
      command.numberOfPayments = numberOfPayments
    then:"We calculate values"
      result == service.calculate(command).rows.size()
    where:"We have next cases"
    numberOfPayments || result
    7                || 7
    1                || 1
  }

  void "should detect an invalid number at calculate table size depending on number of payments"() {
    given:"A simulator command"
      def command = new SimulatorCommand()
      command.numberOfPayments = 0
    when:"Input values"
      service.calculate(command)
    then:"We calculate values"
      thrown SimulatorException
  }


}
