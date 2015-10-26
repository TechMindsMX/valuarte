package com.team.one.command

import com.team.one.domain.Sure

class SureCommand {

  String tipoSeguro
  String nombreBeneficiario1
  String nombreBeneficiario2
  String domicilioBeneficiario1
  String domicilioBeneficiario2	

  Sure generateSure() {
  	new Sure (
			tipoSeguro: this.tipoSeguro,
			nombreBeneficiario1: this.nombreBeneficiario1,
			nombreBeneficiario2: this.nombreBeneficiario2,
			domicilioBeneficiario1: this.domicilioBeneficiario1,
			domicilioBeneficiario2: this.domicilioBeneficiario2	
		)
  }

}