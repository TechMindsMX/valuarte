package com.team.one.command

import com.team.one.domain.enums.*
import com.team.one.domain.TransactionalProfile

class TransactionalProfileCommand {

  FuenteIngresos fuenteIngresos
  String fuenteIngresosOtros
  String profesionOcupacion
  String actividadGiroNegocio
  RangoMensual rangoMensual
  OrigenRecursos origenRecursos
  InstrumentoPago instrumentoPago
  String numeroPagosFrecuencia
  String montoPagos

  TransactionalProfile generateTransactionalProfile() {
  	new TransactionalProfile (
		fuenteIngresos: this.fuenteIngresos,
		fuenteIngresosOtros: this.fuenteIngresosOtros,
		profesionOcupacion: this.profesionOcupacion,
		actividadGiroNegocio: this.actividadGiroNegocio,
		rangoMensual: this.rangoMensual,
		origenRecursos: this.origenRecursos,
		instrumentoPago: this.instrumentoPago,
		numeroPagosFrecuencia: this.numeroPagosFrecuencia,
		montoPagos: this.montoPagos
	)
  }

}