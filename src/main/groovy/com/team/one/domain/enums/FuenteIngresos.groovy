package com.team.one.domain.enums

enum FuenteIngresos {

	SALARIO("Sualdos y Salarios"),
	INVERSIONES("Inversiones"),
	UTILIDADES("Utilidades"),
	ARRENDAMIENTOS("Arrendamientos"),
	HONORARIOS("Honorarios"),
	NEGOCIO("Negocio Propio"),
	OTRO("Otro")

	private final String value

	FuenteIngresos(String value) {
		this.value = value
	}

	String getValue() {
		return value
	}

}