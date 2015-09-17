package com.team.one.domain

import javax.persistence.*

@Entity
class RegistrationCode {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id
  @Column(nullable = false)
  String token = UUID.randomUUID().toString().replaceAll('-', '')
  @Column(nullable = false)
  String username
  @Column
  Date dateCreate = new Date()
  @Column
  Boolean enabled = true
  @Column
  @Enumerated(EnumType.STRING)
  RegistrationCodeStatus status = RegistrationCodeStatus.UNVERIFIED

}
