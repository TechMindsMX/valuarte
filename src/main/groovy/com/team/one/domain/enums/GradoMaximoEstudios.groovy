package com.team.one.domain.enums

enum GradoMaximoEstudios {
  MENORSECUNDARIA("Menor de Secundaria"),
  SECUNDARIA("Secuandaria"),
  TECNICO("Tecnico"),
  BACHILLERATO("Bachillerato"),
  LICENCIATURA("Licenciatura"),
  OTRO("Otro")

  private final String value

  GradoMaximoEstudios(String value) {
  	this.value = value
  }

  String getValue() {
  	return value
  }
}
