package com.team.one.domain

enum PaymentPeriod {
  WEEKLY("Semanal"),
  FORTNIGHT("Quincenal"),
  MONTHLY("Mesual"),

  private final String value

  PaymentPeriod(String value) {
    this.value = value
  }

  String getValue() {
    return value
  }
}
