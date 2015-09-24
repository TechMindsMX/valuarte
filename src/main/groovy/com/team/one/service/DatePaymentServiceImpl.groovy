package com.team.one.service

import com.team.one.domain.SimulatorCommand
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import groovy.time.TimeCategory

@Service
class DatePaymentServiceImpl implements DatePaymentService{

  def generatePaymentDates(SimulatorCommand command){
    def dates = []
    def date = command.startDate

    (1..command.numberOfPayments).each {
      use(TimeCategory){
        dates.add(date)
        if(command.paymentPeriod == PaymentPeriod.MONTHLY)
          date = date + 1.months
        else if(command.paymentPeriod == PaymentPeriod.FORTNIGHT)
          date = date + 15.days
        else if(command.paymentPeriod == PaymentPeriod.WEEKLY)
          date = date + 1.weeks
      }
    }
    dates
  }
}
