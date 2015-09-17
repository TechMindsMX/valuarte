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
      command.tia = 40
      command.paymentPeriod = PaymentPeriod.WEEKLY
    when:"We calculate tim"
      def result = service.calculate(command)
    then:
      result.tim == 3.33
      result.paydays == Paydays.WEEKLY
  }

}
