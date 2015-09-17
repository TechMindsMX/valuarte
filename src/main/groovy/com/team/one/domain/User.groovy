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
  @Column(nullable = true)
  String firstName
  @Column(nullable = true)
  String lastName
  @Column(nullable = true)
  String email
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  Role role
  @Column(nullable = false)
  Boolean enabled = false
  @Column(nullable = false)
  Date dateCreate = new Date()

}
