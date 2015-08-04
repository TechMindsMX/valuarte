package com.team.one.util

class TokenGenerator {
  static def generateToken() {
    UUID.randomUUID().toString().replaceAll('-', '');
  }
}
