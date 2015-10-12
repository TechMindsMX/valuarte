package com.team.one.domain.enums

enum StatusCredit {

  ACTIVE("Activo"),
  CANCELLED("Cancelado"),

  private final String value

  StatusCredit(String value) {
    this.value = value
  }

  String getValue() {
    return value
  }

}
