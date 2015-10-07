package com.team.one.domain

import com.team.one.domain.enums.*
import javax.persistence.*
import static java.util.UUID.randomUUID

class Client {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id

  @Column(nullable = false)
  String uuid = randomUUID().toString().replace('-','')[0..15]

  @Column(nullable = false)
  String montoPrestamo

  @Column(nullable = false)
  String nombre

  @Column(nullable = false)
  String apellidoPaterno

  @Column(nullable = false)
  String apellidoMaterno

  @Column(unique = true, nullable = false)
  String rfc

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
  String nacionalidad

  Long addressId
  Long endorsementId
  Long financialInfoId
  Long referencesId
  Long sureId
  Long transactionalProfileId
  Long workInfoId

  @Column(nullable = false)
  String userCreate

}
