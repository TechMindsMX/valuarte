package com.team.one.domain

import javax.persistence.*
import com.team.one.domain.enums.*

@Entity
class TransactionalProfile {

	@Id
  	@GeneratedValue(strategy=GenerationType.AUTO)
  	Long id

	@Column(nullable = true)
	FuenteIngresos fuenteIngresos
	
	@Column(nullable = true)
	String fuenteIngresosOtros
	
	@Column(nullable = true)
	String profesionOcupacion
	
	@Column(nullable = true)
	String actividadGiroNegocio
	
	@Column(nullable = true)
	RangoMensual rangoMensual
	
	@Column(nullable = true)
	OrigenRecursos origenRecursos
	
	@Column(nullable = true)
	InstrumentoPago instrumentoPago

	@Column(nullable = true)
	String numeroPagosFrecuencia

	@Column(nullable = true)
	String montoPagos

}