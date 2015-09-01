package com.team.one.controller

import org.springframework.web.servlet.ModelAndView
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.security.access.prepost.PreAuthorize

@Controller
@RequestMapping("/simulator")
class SimulatorController {

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(value="/show", method=RequestMethod.GET)
  ModelAndView index(){
  	ModelAndView modelAndView = new ModelAndView("simulator/show")
  	modelAndView
  }

}
