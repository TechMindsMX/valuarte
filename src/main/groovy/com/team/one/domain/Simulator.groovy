package com.team.one.domain

class Simulator {

  BigDecimal tia
  BigDecimal iva
  BigDecimal openingCommission
  BigDecimal loan
  BigDecimal payment
  BigDecimal principle
  BigDecimal lifeInsurance = 0

  PaymentPeriod paymentPeriod
  Integer numberOfPayments
  Date startDate

  def rows = []

}
