package com.team.one.domain

import javax.persistence.*
import com.team.one.domain.enums.*

@Entity
class Endorsement {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id

  @Column(nullable = true)
  String nombreAval
  
  @Column(nullable = true)
  String apellidoPaternoAval
  
  @Column(nullable = true)
  String apellidoMaternoAval
  
  @Column(nullable = true)
  Date fechaNacimeintoAval
  
  @Column(nullable = true)
  TipoIdentificacion identificacionAval
  
  @Column(nullable = true)
  String identificacionOtroAval
  
  @Column(nullable = true)
  String nombreEmpresaAval
  
  @Column(nullable = true)
  String giroActividadAval
  
  @Column(nullable = true)
  String telefonoTrabajoAval
  
  @Column(nullable = true)
  TipoContrato contratoAval
  
  @Column(nullable = true)
  String sueldoMensualAval
  
  @Column(nullable = true)
  String domicilioEmpresaAval
  
  @Column(nullable = true)
  String ciudadEstadoAval

}