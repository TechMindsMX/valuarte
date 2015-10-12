package com.team.one.domain

import javax.persistence.*
import com.team.one.domain.enums.*

@Entity
class FinancialInfo {

	@Id
  	@GeneratedValue(strategy=GenerationType.AUTO)
  	Long id

	@Column(nullable = true)
	Boolean creditoActual
	
	@Column(nullable = true)
	Boolean avalCreditoTercero
	
	@Column(nullable = true)
	String tipoCreditoDeuda1
	
	@Column(nullable = true)
	String institucionDeuda1
	
	@Column(nullable = true)
	String numeroCreditoDeuda1
	
	@Column(nullable = true)
	Date fechaAperturaDeuda1
	
	@Column(nullable = true)
	Date fechaTerminoDeuda1
	
	@Column(nullable = true)
	String montoOtorgadoDeuda1
	
	@Column(nullable = true)
	String tipoCreditoDeuda2
	
	@Column(nullable = true)
	String institucionDeuda2
	
	@Column(nullable = true)
	String numeroCreditoDeuda2
	
	@Column(nullable = true)
	Date fechaAperturaDeuda2
	
	@Column(nullable = true)
	Date fechaTerminoDeuda2
	
	@Column(nullable = true)
	String montoOtorgadoDeuda2
	
	@Column(nullable = true)
	String tipoCreditoDeuda3
	
	@Column(nullable = true)
	String institucionDeuda3
	
	@Column(nullable = true)
	String numeroCreditoDeuda3
	
	@Column(nullable = true)
	Date fechaAperturaDeuda3
	
	@Column(nullable = true)
	Date fechaTerminoDeuda3
	
	@Column(nullable = true)
	String montoOtorgadoDeuda3
	
	@Column(nullable = true)
	String tipoCreditoDeuda4
	
	@Column(nullable = true)
	String institucionDeuda4
	
	@Column(nullable = true)
	String numeroCreditoDeuda4
	
	@Column(nullable = true)
	Date fechaAperturaDeuda4
	
	@Column(nullable = true)
	Date fechaTerminoDeuda4
	
	@Column(nullable = true)
	String montoOtorgadoDeuda4
	
	@Column(nullable = true)
	String nombreBeneficiario

}