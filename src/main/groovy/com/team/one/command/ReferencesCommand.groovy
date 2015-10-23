package com.team.one.command

import com.team.one.domain.References

class ReferencesCommand {
	
	String nombreCompletoRefFamiliar
  String parentescoFamiliar
  String telefonoFamiliar
  String domicilioFamiliar
  String nombreCompletoRefLaboral
  String parentescoLaboral
  String telefonoLaboral
  String domicilioLaboral
  String nombreCompletoRefPersonal1
  String parentescoPersonal1
  String telefonoPersonal1
  String domicilioPersonal1
  String nombreCompletoRefPersonal2
  String parentescoPersonal2
  String telefonoPersonal2
  String domicilioPersonal2


  References generateReferences() {
    new References (
      nombreCompletoRefFamiliar: this.nombreCompletoRefFamiliar,
      parentescoFamiliar: this.parentescoFamiliar,
      telefonoFamiliar: this.telefonoFamiliar,
      domicilioFamiliar: this.domicilioFamiliar,
      nombreCompletoRefLaboral: this.nombreCompletoRefLaboral,
      parentescoLaboral: this.parentescoLaboral,
      telefonoLaboral: this.telefonoLaboral,
      domicilioLaboral: this.domicilioLaboral,
      nombreCompletoRefPersonal1: this.nombreCompletoRefPersonal1,
      parentescoPersonal1: this.parentescoPersonal1,
      telefonoPersonal1: this.telefonoPersonal1,
      domicilioPersonal1: this.domicilioPersonal1,
      nombreCompletoRefPersonal2: this.nombreCompletoRefPersonal2,
      parentescoPersonal2: this.parentescoPersonal2,
      telefonoPersonal2: this.telefonoPersonal2,
      domicilioPersonal2: this.domicilioPersonal2
    )
  }

}