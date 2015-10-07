package com.team.one.command

import com.team.one.domain.enums.*
import com.team.one.domain.Address

class AddressCommand {

	String domicilio
  String telefono
  String celular
  String telefonoOficina
  String email
  TipoVivienda vivienda
  String tiempoResidencia
  String rentaCosto
  String hipotecaCosto
  Integer dependientes
  String codigoPostal
  String calleYNumero
  String colonia
  String delegacionMunicipio
  String ciudadOEstado
  String pais
  String referenciaDomicilio

  Address generateAddress() {
    new Address (
      domicilio: this.domicilio,
      telefono: this.telefono,
      celular: this.celular,
      telefonoOficina: this.telefonoOficina,
      email: this.email,
      vivienda: this.vivienda,
      tiempoResidencia: this.tiempoResidencia,
      rentaCosto: this.rentaCosto,
      hipotecaCosto: this.hipotecaCosto,
      dependientes: this.dependientes,
      codigoPostal: this.codigoPostal,
      calleYNumero: this.calleYNumero,
      colonia: this.colonia,
      delegacionMunicipio: this.delegacionMunicipio,
      ciudadOEstado: this.ciudadOEstado,
      pais: this.pais,
      referenciaDomicilio: this.referenciaDomicilio
    )
  }

}