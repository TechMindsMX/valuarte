package com.team.one.service

import com.team.one.domain.SimulatorCommand
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import groovy.time.TimeCategory
import com.team.one.exception.SimulatorException

@Service
class DatePaymentServiceImpl implements DatePaymentService{

  def generatePaymentDates(SimulatorCommand command){
    def dates = []
    def date = command.startDate

    (1..command.numberOfPayments).each {
      use(TimeCategory){
        dates.add(date)
        switch(command.paymentPeriod){
          case PaymentPeriod.MONTHLY:
            date = date + 1.months
            break
          case PaymentPeriod.FORTNIGHT:
          date = date + 15.days
            break
          case PaymentPeriod.WEEKLY:
          date = date + 1.weeks
            break
          default:
            throw new SimulatorException()
        }
      }
    }
    dates
  }
}
