package com.team.one.domain

class SimulatorCommand {

  String rfc
  String firstName
  String lastName
  Date now

  BigDecimal tia
  BigDecimal iva
  BigDecimal tim
  BigDecimal openingCommission
  BigDecimal payment
  BigDecimal loan
  BigDecimal principle
  BigDecimal lifeInsurance = 0

  PaymentPeriod paymentPeriod
  String paydays
  Integer numberOfPayments
  Date startDate

  def rows = []

}
