package com.team.one.domain

import com.team.one.domain.enums.*
import javax.persistence.*

@Entity
class WorkInfo {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id

  @Column(nullable = true)
  String profecion

  @Column(nullable = true)
  String empresa

  @Column(nullable = true)
  String giroActividad

  @Column(nullable = true)
  TipoContrato contrato

  @Column(nullable = true)
  Date fechaIngreso

  @Column(nullable = true)
  String sueldoMensual

  @Column(nullable = true)
  String domicilioEmpresa

  @Column(nullable = true)
  String ciudadEstadoEmpresa

  @Column(nullable = true)
  String telefonoEmpresa

}
