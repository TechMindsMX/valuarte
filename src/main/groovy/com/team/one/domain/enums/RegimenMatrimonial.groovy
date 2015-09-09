package com.team.one.domain.enums

enum RegimenMatrimonial {
  SEPARACIONBIENES("Separación de Bienes"),
  SOCIEDADCONYUGAL("Sociedad Conyugal")

  private final String value

  RegimenMatrimonial(String value) {
  	this.value = value
  }

  String getValue() {
  	return value
  }

}
