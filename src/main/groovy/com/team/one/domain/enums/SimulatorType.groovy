package com.team.one.domain.enums

enum SimulatorType {

  RESTRUCTURE("Restructure"),
  VALUARTE("Valuarte"),
  REWARD("Reward")

  final String value

  SimulatorType(String value){
    this.value = value
  }

  String getValue() {
    return value
  }

}
