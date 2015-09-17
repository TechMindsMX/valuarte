package com.team.one.domain.enums

enum OrigenRecursos {
	
	TRASPASOCANCELACION("Traspaso / Cancelacion de cuenta en Banco"),
	VENTASNEGOCIO("Venatas del Negocio"),
	PATRIMONIO("Patrimonio/Ahorro"),
	BIENESRAICES("Venta de Bienes Inmuebles"),
	HERENCIA("Herencia/Premio"),
	OTRO("Otro origen")

	private final String value

	OrigenRecursos(String value) {
		this.value = value
	}

	String getValue() {
		return value
	}

}