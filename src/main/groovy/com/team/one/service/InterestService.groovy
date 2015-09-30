package com.team.one.service

import com.team.one.domain.Simulator
import com.team.one.domain.PaymentPeriod

interface InterestService {
  def calculate(BigDecimal capitalBeforePayment, Simulator simulator)
}
