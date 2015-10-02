package com.team.one.domain

import javax.persistence.*

@Entity
class Aval { 

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id

  @Column(nullable = false)
  ºString nombreAval
  
  @Column(nullable = false)
  String apellidoPaternoAval
  
  @Column(nullable = false)
  String apellidoMaternoAval
  
  @Column(nullable = false)
  Date fechaNacimeintoAval
  
  @Column(nullable = false)
  TipoIdentificacion identificacionAval
  
  @Column(nullable = false)
  String identificacionOtroAval
  
  @Column(nullable = false)
  String nombreEmpresaAval
  
  @Column(nullable = false)
  String giroActividadAval
  
  @Column(nullable = false)
  String telefonoTrabajoAval
  
  @Column(nullable = false)
  TipoContrato contratoAval
  
  @Column(nullable = false)
  String sueldoMensualAval
  
  @Column(nullable = false)
  String domicilioEmpresaAval
  
  @Column(nullable = false)
  String ciudadEstadoAval

}