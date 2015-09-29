package com.team.one.domain

enum PaymentPeriod {
  WEEKLY("7,15,21,30",4),
  FORTNIGHT("15,30",2),
  MONTHLY("30",1)

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
