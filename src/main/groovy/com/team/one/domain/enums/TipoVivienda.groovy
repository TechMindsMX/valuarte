package com.team.one.domain.enums

enum TipoVivienda {

  PROPIA("Propia"),
  RENTA("Renta"),
  HIPOTECA("hipoteca"),
  PADRES("Padres/Familiares")

  private final String value

  TipoVivienda(String value) {
    this.value = value
  }

  String getValue() {
    return value
  }

}
