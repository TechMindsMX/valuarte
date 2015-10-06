package com.team.one.domain

import com.team.one.domain.enums.*
import javax.persistence.*

class Domicilio { 

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id

  @Column(nullable = false)
  String domicilio

  @Column(nullable = false)
  String telefono
  
  @Column(nullable = false)
  String celular
  
  @Column(nullable = false)
  String telefonoOficina
  
  @Column(nullable = false)
  String email
  
  @Column(nullable = false)
  TipoVivienda vivienda
  
  @Column(nullable = false)
  String tiempoResidencia
  
  @Column(nullable = false)
  String rentaCosto
  
  @Column(nullable = false)
  String hipotecaCosto
  
  @Column(nullable = false)
  Integer dependientes
  
  @Column(nullable = false)
  String codigoPostal
  
  @Column(nullable = false)
  String calleYNumero
  
  @Column(nullable = false)
  String colonia
  
  @Column(nullable = false)
  String delegacionMunicipio
  
  @Column(nullable = false)
  String ciudadOEstado
  
  @Column(nullable = false)
  String pais
  
  @Column(nullable = false)
  String referenciaDomicilio

}