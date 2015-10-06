package com.team.one.domain

import com.team.one.domain.enums.*
import javax.persistence.*

class DatosLaborales {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id

  @Column(nullable = false)
  String profecion
  
  @Column(nullable = false)
  String empresa
  
  @Column(nullable = false)
  String giroActividad
  
  @Column(nullable = false)
  TipoContrato contrato
  
  @Column(nullable = false)
  Date fechaIngreso
  
  @Column(nullable = false)
  String sueldoMensual
  
  @Column(nullable = false)
  String domicilioEmpresa
  
  @Column(nullable = false)
  String ciudadEstadoAval
  
  @Column(nullable = false)
  String telefonoEmpresa

}