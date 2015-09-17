package com.team.one.domain.validator

import com.team.one.domain.*
import com.team.one.command.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator

@Component
class ChangePasswordFormValidator implements Validator {

  @Override
  boolean supports(Class<?> clazz) {
    clazz.equals(ResetPasswordCommand.class)
  }

  @Override
  void validate(Object target,Errors errors) {
    ResetPasswordCommand form = (ResetPasswordCommand) target;
    validatePasswords(errors, form)
  }

  def validatePasswords(Errors errors, ResetPasswordCommand command) {
    if (!command.password.equals(command.confirPassword))
      errors.reject("password.no:match", "Las contraseñas no coinciden")
    else {
      validateRegex(errors,command)
    }
  }

  def validateRegex(Errors errors, ResetPasswordCommand command) {
    def regex = ~/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{10,}$+/
    if (!command.password.matches(regex) ){
      errors.reject("password.not:regex", "La contraseña debe mantener las reglas de una contraseña segura \n *(Al menos una mayuscula, Alfanumerica y un tamaño minimo de 10 caracteres)")
    }
  }

}