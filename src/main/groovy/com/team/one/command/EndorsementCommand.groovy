package com.team.one.domain

import com.team.one.domain.enums.*

class EndorsementCommand {

	String nombreAval
  String apellidoPaternoAval
  String apellidoMaternoAval
  Date fechaNacimeintoAval
  TipoIdentificacion identificacionAval
  String identificacionOtroAval
  String nombreEmpresaAval
  String giroActividadAval
  String telefonoTrabajoAval
  TipoContrato contratoAval
  String sueldoMensualAval
  String domicilioEmpresaAval
  String ciudadEstadoAval

  Endorsement generateEndorsement() {
    new Endorsement (
      nombreAval: this.nombreAval,
      apellidoPaternoAval: this.apellidoPaternoAval,
      apellidoMaternoAval: this.apellidoMaternoAval,
      fechaNacimeintoAval: this.fechaNacimeintoAval,
      identificacionAval: this.identificacionAval,
      identificacionOtroAval: this.identificacionOtroAval,
      nombreEmpresaAval: this.nombreEmpresaAval,
      giroActividadAval: this.giroActividadAval,
      telefonoTrabajoAval: this.telefonoTrabajoAval,
      contratoAval: this.contratoAval,
      sueldoMensualAval: this.sueldoMensualAval,
      domicilioEmpresaAval: this.domicilioEmpresaAval,
      ciudadEstadoAval: this.ciudadEstadoAval
    )
  }

}
