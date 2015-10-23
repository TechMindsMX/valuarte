package com.team.one.domain

import com.team.one.domain.enums.*
import javax.persistence.*
import com.team.one.domain.*
import static java.util.UUID.randomUUID

@Entity
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

  @Column(nullable = true)
  String gradoOtro

  @Column(nullable = false)
  Genero genero

  @Column(nullable = false)
  TipoIdentificacion identificacion

  @Column(nullable = true)
  String identificacionOtro


  @Column(nullable = false)
  String curp

  @Column(nullable = false)
  String claveElector

  @Column(nullable = false)
  String nacionalidad

  @Column(nullable = false)
  String userCreate

  @OneToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="ADDRESS_ID")
  Address address

  @OneToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="ENDORSENMENT_ID")
  Endorsement endorsement

  @OneToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="FINANCIAL_INFO_ID")
  FinancialInfo financialInfo

  @OneToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="REFERENCE_ID")
  References references

  @OneToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="OWNER_IDENTIFICATION_ID")
  OwnerIdentification ownerIdentification


  @OneToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="TRANSACTIONAL_PROFILE_ID")
  TransactionalProfile transactionalProfile

  @OneToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="WORK_INFO_ID")
  WorkInfo workInfo

}
