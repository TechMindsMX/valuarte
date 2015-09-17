package com.team.one.domain.enums

enum TipoIdentificacion {
  IFE("Credencial para Votar"),
  Cedula("Cedula Profecional"),
  PASAPORTE("Pasaporte"),
  OTRO("Otro")

  private final String value

  TipoIdentificacion(String value) {
    this.value = value
  }

  String getValue() {
    return value
  }

}
