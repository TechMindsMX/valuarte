package com.team.one.util

import spock.lang.Specification
import java.text.NumberFormat

class CurrencyFormatterSpec extends Specification {

  def currencyFormatter = new CurrencyFormatter()

  void "should get a currency format from a payment"(){
  given:"A timestamp"
    def payment = 3411.67
  when: "We get currency format"
    def result = currencyFormatter.format(payment)
  then: "We expect same results"
    result == '$3,411.67'
  }

}

