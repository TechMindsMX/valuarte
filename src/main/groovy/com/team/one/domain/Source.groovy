package com.team.one.domain

import javax.persistence.*

@Entity
class Source {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id

  @Column(nullable = false)
  String name

}
