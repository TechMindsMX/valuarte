package com.team.one.service

import com.team.one.domain.SimulatorCommand
import com.team.one.domain.PaymentPeriod

interface InterestService {
  def calculate(BigDecimal capital, PaymentPeriod paymentPeriod)
}
