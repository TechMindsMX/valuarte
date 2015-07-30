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
    validatePasswords(errors, form);
    validateEmail(errors, form);
  }

  //@Override
  void validatePasswords(Errors errors, UserCommand command) {
    if (!command.password.equals(command.passwordRepeated))
      errors.reject("password.no:match", "passwords do not match")
  }

  //@Override
  void validateEmail(Errors errors, UserCommand command) {
    if (userService.getUserByUsername(command.username) != null)
      errors.reject("email.exists", "User with this email already exists")
  }


}
