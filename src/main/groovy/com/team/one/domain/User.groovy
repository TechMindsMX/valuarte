package com.team.one.domain

import java.io.Serializable
import javax.persistence.*

@Entity
class User implements Serializable {

  static final long serialVersionUID = 7526472295622776147L

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
