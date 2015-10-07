package com.team.one.domain

import javax.persistence.*
import com.team.one.domain.enums.*

@Entity
class TransactionalProfile {

	@Id
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

	@Column(nullable = false)
	String numeroPagosFrecuencia

	@Column(nullable = false)
	String montoPagos

}