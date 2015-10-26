package com.team.one.command

import com.team.one.domain.enums.*
import com.team.one.domain.Client

class ClientCommand {

	String montoPrestamo
  String nombre
  String apellidoPaterno
  String apellidoMaterno
  String rfc
  Date fechaNacimiento
  Integer edad
  EstadoCivil estadoCivil
  RegimenMatrimonial regimen
  GradoMaximoEstudios grado
  String gradoOtro
  Genero genero
  TipoIdentificacion identificacion
  String identificacionOtro
  String curp
  String claveElector
  String nacionalidad

  Client generateClient() {
    new Client (
      montoPrestamo: this.montoPrestamo,
      nombre: this.nombre,
      apellidoPaterno: this.apellidoPaterno,
      apellidoMaterno: this.apellidoMaterno,
      rfc: this.rfc,
      fechaNacimiento: this.fechaNacimiento,
      edad: this.edad,
      estadoCivil: this.estadoCivil,
      regimen: this.regimen,
      grado: this.grado,
      gradoOtro: this.gradoOtro,
      genero: this.genero,
      identificacion: this.identificacion,
      identificacionOtro: this.identificacionOtro,
      curp: this.curp,
      claveElector: this.claveElector,
      nacionalidad: this.nacionalidad
    )
  }

}
