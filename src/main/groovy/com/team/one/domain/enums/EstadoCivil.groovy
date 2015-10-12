package com.team.one.domain.enums

enum EstadoCivil {
  CASADO("Casado"),
  SOLTERO("Soltero/a"),
  UNIONLIBRE("Union Libre"),
  VIUDO("Viudo/a")

  private final String value

  EstadoCivil(String value) {
    this.value = value
  }

  String getValue() {
    return value
  }

}
