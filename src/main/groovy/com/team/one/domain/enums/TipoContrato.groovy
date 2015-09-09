package com.team.one.domain.enums

enum TipoContrato {

  PLANTA("Planta"),
  EVENTUAL("Eventual")

  private final String value

  TipoContrato(String value) {
    this.value = value
  }

  String getValue() {
    return value
  }

}
