package com.team.one.domain

import javax.persistence.*
import com.team.one.domain.enums.*

@Entity
class Sure {

	@Id
  	@GeneratedValue(strategy=GenerationType.AUTO)
  	Long id

	@Column(nullable = true)
	String tipoSeguro
	
	@Column(nullable = true)
	String nombreBeneficiario1
	
	@Column(nullable = true)
	String nombreBeneficiario2
	
	@Column(nullable = true)
	String domicilioBeneficiario1
	
	@Column(nullable = true)
	String domicilioBeneficiario2

}