package com.team.one.domain

import javax.persistence.*

@Entity
class Client {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id

  @Column(nullable = false)
  String uuid

  @Column(unique = true, nullable = false)
  String rfc

  @Column(nullable = false)
  String name

  @Column(nullable = false)
  String lastName

}
