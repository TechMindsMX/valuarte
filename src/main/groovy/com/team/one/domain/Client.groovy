package com.team.one.domain

import javax.persistence.*

@Entity
class Client {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id

  @Column(nullable = false)
  String uuid

  @Column(nullable = false)
  String montoPrestamo

  @Column(nullable = false)
  String nombre

  @Column(nullable = false)
  String apellidoPaterno

  @Column(unique = true, nullable = false)
  String rfc

  @Column(nullable = false)
  String apellidoMaterno

  @Column(nullable = false)
  Date fechaNacimiento

  @Column(nullable = false)
  Integer edad

  @Column(nullable = false)
  EstadoCivil estadoCivil

  @Column(nullable = false)
  RegimenMatrimonial regimen

  @Column(nullable = false)
  GradoMaximoEstudios grado

  @Column(nullable = false)
  String gradoOtro

  @Column(nullable = false)
  Genero genero

  @Column(nullable = false)
  TipoIdentificacion identificacion

  @Column(nullable = false)
  String identificacionOtro


  @Column(nullable = false)
  String fiel
  
  @Column(nullable = false)
  String curp
  
  @Column(nullable = false)
  String claveElector
  
  @Column(nullable = false)
  String telefono
  
  @Column(nullable = false)
  String celular
  
  @Column(nullable = false)
  String telefonoOficina
  
  @Column(nullable = false)
  String email
  
  @Column(nullable = false)
  String nacionalidad
  
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
  String ciudadEstadoEmpresa
  
  @Column(nullable = false)
  String telefonoEmpresa

}
