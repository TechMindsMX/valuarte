package com.team.one.command

import com.team.one.domain.FinancialInfo

class FinancialInfoCommand {

  Boolean creditoActual
  Boolean avalCreditoTercero
  String tipoCreditoDeuda1
  String institucionDeuda1
  String numeroCreditoDeuda1
  Date fechaAperturaDeuda1
  Date fechaTerminoDeuda1
  String montoOtorgadoDeuda1
  String tipoCreditoDeuda2
  String institucionDeuda2
  String numeroCreditoDeuda2
  Date fechaAperturaDeuda2
  Date fechaTerminoDeuda2
  String montoOtorgadoDeuda2
  String tipoCreditoDeuda3
  String institucionDeuda3
  String numeroCreditoDeuda3
  Date fechaAperturaDeuda3
  Date fechaTerminoDeuda3
  String montoOtorgadoDeuda3
  String tipoCreditoDeuda4
  String institucionDeuda4
  String numeroCreditoDeuda4
  Date fechaAperturaDeuda4
  Date fechaTerminoDeuda4
  String montoOtorgadoDeuda4
  String nombreBeneficiario

  FinancialInfo generateFinancialInfo() {
    new FinancialInfo (
        creditoActual: this.creditoActual,
        avalCreditoTercero: this.avalCreditoTercero,
        tipoCreditoDeuda1: this.tipoCreditoDeuda1,
        institucionDeuda1: this.institucionDeuda1,
        numeroCreditoDeuda1: this.numeroCreditoDeuda1,
        fechaAperturaDeuda1: this.fechaAperturaDeuda1,
        fechaTerminoDeuda1: this.fechaTerminoDeuda1,
        montoOtorgadoDeuda1: this.montoOtorgadoDeuda1,
        tipoCreditoDeuda2: this.tipoCreditoDeuda2,
        institucionDeuda2: this.institucionDeuda2,
        numeroCreditoDeuda2: this.numeroCreditoDeuda2,
        fechaAperturaDeuda2: this.fechaAperturaDeuda2,
        fechaTerminoDeuda2: this.fechaTerminoDeuda2,
        montoOtorgadoDeuda2: this.montoOtorgadoDeuda2,
        tipoCreditoDeuda3: this.tipoCreditoDeuda3,
        institucionDeuda3: this.institucionDeuda3,
        numeroCreditoDeuda3: this.numeroCreditoDeuda3,
        fechaAperturaDeuda3: this.fechaAperturaDeuda3,
        fechaTerminoDeuda3: this.fechaTerminoDeuda3,
        montoOtorgadoDeuda3: this.montoOtorgadoDeuda3,
        tipoCreditoDeuda4: this.tipoCreditoDeuda4,
        institucionDeuda4: this.institucionDeuda4,
        numeroCreditoDeuda4: this.numeroCreditoDeuda4,
        fechaAperturaDeuda4: this.fechaAperturaDeuda4,
        fechaTerminoDeuda4: this.fechaTerminoDeuda4,
        montoOtorgadoDeuda4: this.montoOtorgadoDeuda4,
        nombreBeneficiario: this.nombreBeneficiario
    )

  }
	
}