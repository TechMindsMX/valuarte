package com.team.one.command

import com.team.one.domain.enums.*
import com.team.one.domain.WorkInfo

class WorkInfoCommand {

	String profecion
  String empresa
  String giroActividad
  TipoContrato contrato
  Date fechaIngreso
  String sueldoMensual
  String domicilioEmpresa
  String ciudadEstadoEmpresa
  String telefonoEmpresa

  WorkInfo generateWorkInfo () {
  	new WorkInfo(
  		profecion: this.profecion,
			empresa: this.empresa,
			giroActividad: this.giroActividad,
			contrato: this.contrato,
			fechaIngreso: this.fechaIngreso,
			sueldoMensual: this.sueldoMensual,
			domicilioEmpresa: this.domicilioEmpresa,
			ciudadEstadoEmpresa: this.ciudadEstadoEmpresa,
			telefonoEmpresa: this.telefonoEmpresa
  	)
  }

}