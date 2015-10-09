package com.team.one.domain.enums

enum RangoMensual {
	
	DIEZMIL("\$1,000.00 - \$10,000.00"),
	VEINTEMIL("\$10,001.00 - 20,000.00"),
	TREINTAMIL("\$20,001.00 - \$30,000.00"),
	CINCUENTAMIL("\$30,001.00 - \$50,000.00"),
	CIENMIL("\$50,001.00 - \$100,000.00"),
	QUINIENTOSMIL("\$100,001.00 - \$500,000.00"),
	ADELANTE("\$500,001.00 - En Adelante")

	private final String value

	RangoMensual(String value) {
		this.value = value
	}

	String getValue() {
		return value
	}

}