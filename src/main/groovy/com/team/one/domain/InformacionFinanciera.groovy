package com.team.one.domain

import javax.persistence.*
import com.team.one.domain.enums.*

@Entity
class InformacionFinanciera { 

	@Id
  	@GeneratedValue(strategy=GenerationType.AUTO)
  	Long id

	@Column(nullable = false)
	Boolean creditoActual
	
	@Column(nullable = false)
	Boolean avalCreditoTercero
	
	@Column(nullable = false)
	String tipoCreditoDeuda1
	
	@Column(nullable = false)
	String institucionDeuda1
	
	@Column(nullable = false)
	String numeroCreditoDeuda1
	
	@Column(nullable = false)
	Date fechaAperturaDeuda1
	
	@Column(nullable = false)
	Date fechaTerminoDeuda1
	
	@Column(nullable = false)
	String montoOtorgadoDeuda1
	
	@Column(nullable = false)
	String tipoCreditoDeuda2
	
	@Column(nullable = false)
	String institucionDeuda2
	
	@Column(nullable = false)
	String numeroCreditoDeuda2
	
	@Column(nullable = false)
	Date fechaAperturaDeuda2
	
	@Column(nullable = false)
	Date fechaTerminoDeuda2
	
	@Column(nullable = false)
	String montoOtorgadoDeuda2
	
	@Column(nullable = false)
	String tipoCreditoDeuda3
	
	@Column(nullable = false)
	String institucionDeuda3
	
	@Column(nullable = false)
	String numeroCreditoDeuda3
	
	@Column(nullable = false)
	Date fechaAperturaDeuda3
	
	@Column(nullable = false)
	Date fechaTerminoDeuda3
	
	@Column(nullable = false)
	String montoOtorgadoDeuda3
	
	@Column(nullable = false)
	String tipoCreditoDeuda4
	
	@Column(nullable = false)
	String institucionDeuda4
	
	@Column(nullable = false)
	String numeroCreditoDeuda4
	
	@Column(nullable = false)
	Date fechaAperturaDeuda4
	
	@Column(nullable = false)
	Date fechaTerminoDeuda4
	
	@Column(nullable = false)
	String montoOtorgadoDeuda4
	
	@Column(nullable = false)
	String nombreBeneficiario

}