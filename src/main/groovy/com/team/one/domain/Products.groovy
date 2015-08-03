package com.team.one.domain

import javax.persistence.*

@Entity
class Products {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id
  @Column(uniq = true, nullable = false)
  BigInteger sku
  @Column(nullable = false)
  Integer price
  @Column(nullable = false)
  String description


}
