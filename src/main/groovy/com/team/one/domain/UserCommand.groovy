package com.team.one.domain

import org.hibernate.validator.constraints.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class UserCommand {

  @NotEmpty(message = "El campo Usuario no puede estar vacio")
  String username

  @NotEmpty(message = "El campo Contraseña no puede estar vacio")
  @Size(min = 10, max = 50)
  String password

  @NotEmpty(message = "El campo confirma contraseña no puede estar vacio")
  @Size(min = 10, max = 50)
  String passwordRepeated

  String firstName

  String lastName

  @Email
  String email

  @NotNull
  Role role = Role.USER

  @Override
  String toString() {
      "${firstName} ${lastName} as ${username}"
  }

}
