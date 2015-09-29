package com.team.one.domain

enum PaymentPeriod {
  WEEKLY("Semanal",4),
  FORTNIGHT("Quincenal",2),
  MONTHLY("Mensual",1)

  private final String value
  private final Integer factor

  PaymentPeriod(String value, Integer factor) {
    this.value = value
    this.factor = factor
  }

  Integer getFactor(){
    factor
  }

  String getValue() {
    value
  }
}
