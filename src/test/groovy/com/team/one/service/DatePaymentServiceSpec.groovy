package com.team.one.service

import spock.lang.Specification
import com.team.one.domain.SimulatorCommand
import com.team.one.service.SimulatorDataServiceImpl
import com.team.one.domain.PaymentPeriod
import com.team.one.domain.Paydays
import com.team.one.exception.SimulatorException

class DatePaymentServiceSpec extends Specification {

  DatePaymentServiceImpl service = new DatePaymentServiceImpl()

  void "should generate payment dates based in number of payment and start payment date"() {
    given:"A simulator command and principle"
      def command = new SimulatorCommand()
      command.numberOfPayments = 2
      command.startDate = new Date("9/15/2015")
    when:"We calculate data"
      def result = service.generatePaymentDates(command)
    then:"We expect same principle with capital before payment"
      result.get(0) == new Date("9/15/2015")
      result.get(1) == new Date("9/30/2015")
  }

}
