package com.team.one.controller

import org.springframework.stereotype.Controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletResponse

import com.team.one.service.ClientService

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Controller
@RequestMapping("/client")
class ClientController {

  @Autowired
  ClientService clientService

  Logger log = LoggerFactory.getLogger(getClass())

  @RequestMapping(method=RequestMethod.GET)
  @ResponseBody
  def findClientByRfc(@RequestParam String rfc, HttpServletResponse response){
    log.info "FINDING Client by rfc: $rfc"

    response.addHeader("Allow-Control-Allow-Methods", "GET");
    response.addHeader("Access-Control-Allow-Origin", "*");
    clientService.findByRfc(rfc)
  }

}
