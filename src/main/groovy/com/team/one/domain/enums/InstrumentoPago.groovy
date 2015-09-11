package com.team.one.domain.enums

enum InstrumentoPago {

	EFECTIVO("Efectivo"),
	CHEQUE("Cheque"),
	TRASPASO("Traspaso"),
	SPEI("SPEI")

	private final String value

	InstrumentoPago(String value) {
		this.value = value
	}

	String getValue() {
		return value
	}

}