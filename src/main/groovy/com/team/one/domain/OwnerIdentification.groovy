package com.team.one.domain

import javax.persistence.*

@Entity
class OwnerIdentification {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id

  @Column(nullable = true)
  String actuar

  @Column(nullable = true)
  String recursos

  @Column(nullable = true)
  String aportaciones

}
