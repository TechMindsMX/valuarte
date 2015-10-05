package com.team.one.domain

import javax.validation.constraints.DecimalMin
import javax.validation.constraints.NotNull

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

  @NotNull
  @DecimalMin(value="0.01", inclusive=true)
  BigDecimal loan

  BigDecimal principle
  BigDecimal lifeInsurance = 0

  PaymentPeriod paymentPeriod
  String paydays
  Integer numberOfPayments
  Date startDate

}
