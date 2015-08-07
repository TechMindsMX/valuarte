package com.team.one.domain

import javax.persistence.*

@Entity
class Product {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id
  @Column(unique = true, nullable = false)
  Integer sku
  @Column(nullable = false)
  Integer price
  @Column(nullable = false)
  String description

}
