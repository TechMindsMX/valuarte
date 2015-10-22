package com.team.one.domain

import org.springframework.data.annotation.Id
import com.team.one.domain.enums.SimulatorType

class Simulator {

  @Id
  String id

  BigDecimal tia
  BigDecimal iva
  BigDecimal commission
  BigDecimal loan
  BigDecimal payment
  BigDecimal principle
  BigDecimal lifeInsurance = 0
  BigDecimal openingCommission
  SimulatorType type

  PaymentPeriod paymentPeriod
  Integer numberOfPayments
  Date startDate

  def rows = []

}
