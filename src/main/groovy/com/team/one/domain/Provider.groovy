package com.team.one.domain

import javax.persistence.*

@Entity
class Provider {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id

  @Column(nullable = false)
  String name
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  Type type

}
