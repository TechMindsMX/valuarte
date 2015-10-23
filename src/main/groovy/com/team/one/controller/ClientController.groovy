package com.team.one.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Controller
@RequestMapping("/client")
class ClientController {

  Logger log = LoggerFactory.getLogger(getClass())

  @RequestMapping(method=RequestMethod.GET)
  @ResponseBody
  def findClientByRfc(@RequestParam String rfc){
    log.info "FINDING Client by rfc: $rfc"
  }
}
