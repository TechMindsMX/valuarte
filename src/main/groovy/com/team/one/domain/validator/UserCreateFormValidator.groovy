package com.team.one.domain.validator

import com.team.one.domain.*
import com.team.one.service.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator

@Component
class UserCreateFormValidator implements Validator {

  @Autowired
  UserService userService

  @Override
  boolean supports(Class<?> clazz) {
    clazz.equals(UserCommand.class)
  }

  @Override
  void validate(Object target,Errors errors) {
    UserCommand form = (UserCommand) target;
    def errorList = []
    errorList << validatePasswords(errors, form)
    errorList << validateEmail(errors, form)
    errorList
  }

  def validatePasswords(Errors errors, UserCommand command) {
    if (!command.password.equals(command.passwordRepeated))
      errors.reject("password.no:match", "Las contraseñas no coinciden")
    else {
      validateRegex(errors,command)
    }
  }

  def validateEmail(Errors errors, UserCommand command) {
    if (!userService.getUserByUsername(command.username).empty())
      errors.reject("username.exists", "el nombre de usuario ya existe")
  }

  def validateRegex(Errors errors, UserCommand command) {
    def regex = ~/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{10,}$+/
    if (!command.password.matches(regex) ){
      errors.reject("password.not:regex", "La contraseña debe mantener las reglas de una contraseña segura \n *(Al menos una mayuscula, Alfanumerica y un tamaño minimo de 10 caracteres)")
    }
  }

}
