package com.team.one.controller

import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.HandlerExceptionResolver
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component

@Component
class HandlerException implements HandlerExceptionResolver {

  ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
    new ModelAndView("error",[:])
  }

}
