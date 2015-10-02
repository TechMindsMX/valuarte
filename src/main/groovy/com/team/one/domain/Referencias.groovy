package com.team.one.domain

import javax.persistence.*

@Entity
class Referencias { 

	Id
  	@GeneratedValue(strategy=GenerationType.AUTO)
  	Long id

	
	@Column(nullable = false)
	String nombreCompletoRefFamiliar
	
	@Column(nullable = false)
	String parentescoFamiliar
	
	@Column(nullable = false)
	String telefonoFamiliar
	
	@Column(nullable = false)
	String domicilioFamiliar
	
	@Column(nullable = false)
	String nombreCompletoRefLaboral
	
	@Column(nullable = false)
	String parentescoLaboral
	
	@Column(nullable = false)
	String telefonoLaboral
	
	@Column(nullable = false)
	String domicilioLaboral
	
	@Column(nullable = false)
	String nombreCompletoRefPersonal1
	
	@Column(nullable = false)
	String parentescoPersonal1
	
	@Column(nullable = false)
	String telefonoPersonal1
	
	@Column(nullable = false)
	String domicilioPersonal1
	
	@Column(nullable = true)
	String nombreCompletoRefPersonal2
	
	@Column(nullable = true)
	String parentescoPersonal2
	
	@Column(nullable = true)
	String telefonoPersonal2
	
	@Column(nullable = true)
	String domicilioPersonal2


}