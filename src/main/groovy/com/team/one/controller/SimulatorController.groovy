package com.team.one.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.servlet.ModelAndView
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.ui.Model
import com.team.one.domain.SimulatorCommand
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.team.one.service.SimulatorService

@Controller
@RequestMapping("/simulator")
class SimulatorController {

  @Autowired
  SimulatorService simulatorService

  Logger log = LoggerFactory.getLogger(getClass());

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(value="/create", method=RequestMethod.GET)
  String create(Model model){
    log.info "Creating new simulator form"
    def simulator = new SimulatorCommand()
    simulator.now = new Date()
    model.addAttribute("simulator", simulator)
    "simulator/form"
  }

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(value="/save", method=RequestMethod.POST)
  ModelAndView save(@ModelAttribute("simulator") SimulatorCommand simulator){
    log.info "Saving new simulator simulator"
  	ModelAndView modelAndView = new ModelAndView("simulator/show")
    simulatorService.calculate(simulator)
    modelAndView.addObject("simulator", simulator)
  	modelAndView
  }


}
