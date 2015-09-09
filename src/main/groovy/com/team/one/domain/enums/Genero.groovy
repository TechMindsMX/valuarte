package com.team.one.domain.enums

enum Genero {
 MASCULINO("Masculino"),
 FEMENINO("Femenino")

 private final String value

 Genero(String value) {
 	this.value = value
 }

 String getValue() {
 	return value
 }

}
