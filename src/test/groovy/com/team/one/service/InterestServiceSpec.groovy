package com.team.one.service

import spock.lang.Specification
import com.team.one.domain.PaymentPeriod

class InterestServiceSpec extends Specification {

  InterestServiceImpl service = new InterestServiceImpl()

  void "should calculate interest based in capital and a monthly payment period"() {
    when:"A base capital"
    then:"We calculate values"
      result == service.calculate(capital, paymentPeriod)
    where:"We have next cases"
      capital  | paymentPeriod          || result
      null     | PaymentPeriod.MONTHLY  || 0
  }

}
