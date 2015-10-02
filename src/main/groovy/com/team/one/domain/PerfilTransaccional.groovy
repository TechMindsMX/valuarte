package com.team.one.domain

import javax.persistence.*

@Entity
class PerfilTransaccional { 

	Id
  	@GeneratedValue(strategy=GenerationType.AUTO)
  	Long id

	@Column(nullable = false)
	FuenteIngresos fuenteIngresos
	
	@Column(nullable = false)
	String fuenteIngresosOtros
	
	@Column(nullable = false)
	String profesionOcupacion
	
	@Column(nullable = false)
	String actividadGiroNegocio
	
	@Column(nullable = false)
	RangoMensual rangoMensual
	
	@Column(nullable = false)
	OrigenRecursos origenRecursos
	
	@Column(nullable = false)
	InstrumentoPago instrumentoPago

}