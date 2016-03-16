package com.team.one.domain

import javax.persistence.*

@Entity
class PLDInterview {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id

  @Column(nullable = false)
  String gobierno

  @Column(nullable = false)
  String consanguineo

  @Column(nullable = false)
  String ingresos

  @Column(nullable = false)
  BigDecimal monto

}
