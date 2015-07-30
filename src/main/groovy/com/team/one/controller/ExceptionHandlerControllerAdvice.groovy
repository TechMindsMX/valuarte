package com.team.one.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.NoSuchElementException

@ControllerAdvice
class ExceptionHandlerControllerAdvice {
  
  @ExceptionHandler(NoSuchElementException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String handleNoSuchElementException(NoSuchElementException e) {
    e.getMessage()
  }

}