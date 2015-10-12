package com.team.one.domain

import javax.persistence.*
import com.team.one.domain.enums.StatusCredit

@Entity
class UserClient {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id

  User user
  Client client

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  StatusCredit status

}
