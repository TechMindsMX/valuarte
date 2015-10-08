package com.team.one.command

import com.team.one.domain.PaymentPeriod

import javax.validation.constraints.DecimalMin
import javax.validation.constraints.NotNull
import javax.validation.constraints.Min

class SimulatorCommand {

  String rfc
  String nombre
  String apellidoPaterno
  String apellidoMaterno
  Date now

  BigDecimal openingCommission
  BigDecimal payment
  BigDecimal principle
  BigDecimal lifeInsurance = 0

  PaymentPeriod paymentPeriod
  String paydays
  Date startDate

  @NotNull
  @DecimalMin(value="0.01", inclusive=true)
  BigDecimal tia

  @NotNull
  @DecimalMin(value="0.01", inclusive=true)
  BigDecimal iva

  @NotNull
  @DecimalMin(value="0.01", inclusive=true)
  BigDecimal loan

  @NotNull
  @Min(1L)
  Integer numberOfPayments

}
