package com.team.one.controller

import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.HandlerExceptionResolver
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component

import com.team.one.exception.SimulatorException

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Component
class HandlerException implements HandlerExceptionResolver {

  Logger log = LoggerFactory.getLogger(getClass())

  ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
    log.info ex.message

    if(ex instanceof SimulatorException){
      def data = [:]
      data.message = ex.message
      log.info "request: ${request.dump()}"
      ModelAndView modelAndView = new ModelAndView("error")
      modelAndView.addObject("data", data)
      modelAndView
    }
  }

}
