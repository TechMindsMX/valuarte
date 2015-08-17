package com.team.one.domain

import org.hibernate.validator.constraints.NotEmpty
import javax.validation.constraints.NotNull

class UserCommand {

  @NotEmpty
  String username

  @NotEmpty
  String password

  @NotEmpty
  String passwordRepeated

  String firstName

  String lastName

  String email

  @NotNull
  Role role = Role.USER

  @Override
  String toString() {
      "${firstName} ${lastName} as ${username}"
  }

}
