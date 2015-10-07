package com.team.one.command

import com.team.one.domain.PaymentPeriod

class SimulatorCommand {

  String rfc
  String nombre
  String apellidoPaterno
  String apellidoMaterno
  Date now

  BigDecimal tia
  BigDecimal iva
  BigDecimal openingCommission
  BigDecimal payment
  BigDecimal loan
  BigDecimal principle
  BigDecimal lifeInsurance = 0

  PaymentPeriod paymentPeriod
  String paydays
  Integer numberOfPayments
  Date startDate

}
