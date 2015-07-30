package com.team.one.domain

import javax.persistence.*

@Entity
class User {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id
  @Column(unique = true, nullable = false)
  String username
  @Column(nullable = false)
  String password
  @Column(nullable = false)
  String firstName
  @Column(nullable = false)
  String lastName
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  Role role

}
