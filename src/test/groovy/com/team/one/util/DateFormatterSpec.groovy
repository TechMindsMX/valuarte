package com.team.one.util

import spock.lang.Specification
import java.text.SimpleDateFormat

class DateFormatterSpec extends Specification {

  def dateFormatter = new DateFormatter()

  void "should get a date in YYYY-MM-DD format from a timestamp"(){
  given:"A date"
    def date = new Date(1438975696592L)
  when: "We get current date"
    def result = dateFormatter.format(date)
  then: "We expect same results"
    '2015-08-07' == result
  }


  void "should get current date in YYYY-MM-DD format"(){
  given:"A date"
    def date = new Date()
  when: "We get current date"
    def result = dateFormatter.format(date)
  then: "We expect same results"
    new SimpleDateFormat("yyyy-MM-dd").format(date) == result
  }
}

