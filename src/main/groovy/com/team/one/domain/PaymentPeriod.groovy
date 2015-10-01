package com.team.one.domain

enum PaymentPeriod {
  WEEKLY("Semanal","7,15,21,30",4),
  FORTNIGHT("Quincenal","15,30",2),
  MONTHLY("Mensual","30",1)

  private final String label
  private final String value
  private final Integer factor

  PaymentPeriod(String label, String value, Integer factor) {
    this.label = label
    this.value = value
    this.factor = factor
  }

  String getLabel() {
    label
  }

  String getValue() {
    value
  }

  Integer getFactor(){
    factor
  }

}
