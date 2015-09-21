package com.team.one.service

import spock.lang.Specification
import com.team.one.domain.SimulatorCommand
import com.team.one.service.PMTServiceImpl
import com.team.one.domain.PaymentPeriod
import com.team.one.domain.Paydays
import com.team.one.exception.SimulatorException

class SimulatorDataServiceSpec extends Specification {

  SimulatorDataServiceImpl service = new SimulatorDataServiceImpl()

  void "should calculate payment in a monthly payment period"() {
    given:"A simulator command"
      def command = new SimulatorCommand()
    when:"Input values"
      command.numberOfPayments = 7
    then:"We calculate values"
      result == service.calculate(command).rows.size()
    where:"We have next cases"
    numberOfPayments || result
    7                || 7
  }

}
