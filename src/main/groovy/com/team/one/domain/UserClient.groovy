package com.team.one.domain

import javax.persistence.*
import com.team.one.domain.enums.StatusCredit
import com.team.one.domain.*

@Entity
class UserClient {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id

  @OneToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="USER_ID")
  User user
  @OneToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="CLIENT_ID")
  Client client

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  StatusCredit status

}
