package com.team.one.domain

enum Paydays {
  WEEKLY("7,15,21,30"),
  FORTNIGHT("15,30"),
  MONTHLY("30"),

  private final String value

  Paydays(String value) {
    this.value = value
  }

  String getValue() {
    return value
  }
}
