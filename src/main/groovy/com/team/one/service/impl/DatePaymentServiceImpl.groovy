package com.team.one.service.impl

import com.team.one.domain.Simulator
import com.team.one.service.DatePaymentService
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import groovy.time.TimeCategory
import com.team.one.exception.SimulatorException

//TODO: Externalizar los mensajes de error

@Service
class DatePaymentServiceImpl implements DatePaymentService{

  def generatePaymentDates(Simulator simulator){
    def dates = []
    def date = simulator.startDate

    (1..simulator.numberOfPayments).each {
      use(TimeCategory){
        dates.add(date)
        switch(simulator.paymentPeriod){
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
            throw new SimulatorException('No se ha proporcionado un periodo de pago válido')
        }
      }
    }
    dates
  }
}
