package com.team.one.domain

import com.team.one.domain.enums.*
import javax.persistence.*

@Entity
class Address {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id

  @Column(nullable = true)
  String domicilio

  @Column(nullable = true)
  String telefono
  
  @Column(nullable = true)
  String celular
  
  @Column(nullable = true)
  String telefonoOficina
  
  @Column(nullable = true)
  String email
  
  @Column(nullable = true)
  TipoVivienda vivienda
  
  @Column(nullable = true)
  String tiempoResidencia
  
  @Column(nullable = true)
  String rentaCosto
  
  @Column(nullable = true)
  String hipotecaCosto
  
  @Column(nullable = true)
  Integer dependientes
  
  @Column(nullable = true)
  String codigoPostal
  
  @Column(nullable = true)
  String calleYNumero
  
  @Column(nullable = true)
  String colonia
  
  @Column(nullable = true)
  String delegacionMunicipio
  
  @Column(nullable = true)
  String ciudadOEstado
  
  @Column(nullable = true)
  String pais
  
  @Column(nullable = true)
  String referenciaDomicilio

}