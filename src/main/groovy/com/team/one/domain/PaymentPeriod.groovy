package com.team.one.domain

enum PaymentPeriod {
  WEEKLY("Semanal"),
  FORTNIGHT("Quincenal"),
  MONTHLY("Mensual"),

  private final String value

  PaymentPeriod(String value) {
    this.value = value
  }

  String getValue() {
    return value
  }
}
