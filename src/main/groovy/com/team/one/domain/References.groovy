package com.team.one.domain

import javax.persistence.*
import com.team.one.domain.enums.*

@Entity
class References {

	@Id
  	@GeneratedValue(strategy=GenerationType.AUTO)
  	Long id

	
	@Column(nullable = true)
	String nombreCompletoRefFamiliar
	
	@Column(nullable = true)
	String parentescoFamiliar
	
	@Column(nullable = true)
	String telefonoFamiliar
	
	@Column(nullable = true)
	String domicilioFamiliar
	
	@Column(nullable = true)
	String nombreCompletoRefLaboral
	
	@Column(nullable = true)
	String parentescoLaboral
	
	@Column(nullable = true)
	String telefonoLaboral
	
	@Column(nullable = true)
	String domicilioLaboral
	
	@Column(nullable = true)
	String nombreCompletoRefPersonal1
	
	@Column(nullable = true)
	String parentescoPersonal1
	
	@Column(nullable = true)
	String telefonoPersonal1
	
	@Column(nullable = true)
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