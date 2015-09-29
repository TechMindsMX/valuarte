package com.team.one.service

import com.team.one.domain.SimulatorCommand

interface DatePaymentService {
  def generatePaymentDates(SimulatorCommand command)
}
