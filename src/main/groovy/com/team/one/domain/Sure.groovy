package com.team.one.domain

import javax.persistence.*
import com.team.one.domain.enums.*

@Entity
class Sure {

	@Id
  	@GeneratedValue(strategy=GenerationType.AUTO)
  	Long id

	@Column(nullable = false)
	String tipoSeguro
	
	@Column(nullable = false)
	String nombreBeneficiario1
	
	@Column(nullable = false)
	String nombreBeneficiario2
	
	@Column(nullable = false)
	String domicilioBeneficiario1
	
	@Column(nullable = false)
	String domicilioBeneficiario2

}