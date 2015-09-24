package com.team.one.service

import com.team.one.domain.SimulatorCommand
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import groovy.time.TimeCategory

@Service
class DatePaymentServiceImpl implements DatePaymentService{

  def generatePaymentDates(SimulatorCommand command){
    def dates = []
    def startDate = command.startDate
    dates.add(startDate)

    (1..command.numberOfPayments).each {
      use(TimeCategory){
        dates.add(startDate + 15.days)
      }
    }
    dates
  }
}
