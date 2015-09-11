package com.team.one.controller

import org.springframework.web.servlet.ModelAndView
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.ui.Model
import com.team.one.domain.ClientCommand
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Controller
@RequestMapping("/simulator")
class SimulatorController {

  Logger log = LoggerFactory.getLogger(getClass());

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(value="/create", method=RequestMethod.GET)
  String create(Model model){
    log.info "Creating new simulator form"
    def client = new ClientCommand()
    client.now = new Date()
    model.addAttribute("client", client)
    "simulator/form"
  }

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(value="/save", method=RequestMethod.POST)
  ModelAndView save(@ModelAttribute("form") ClientCommand form){
    log.info "Saving new simulator client"
  	ModelAndView modelAndView = new ModelAndView()
    log.info "client: ${form.dump()}"
  	modelAndView
  }


}
