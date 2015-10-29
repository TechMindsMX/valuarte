package com.team.one.domain

import javax.persistence.*

@Entity
class CostHealthInsurence {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id

  String optionPack
  String sex
  Integer age
  BigDecimal cost

}
