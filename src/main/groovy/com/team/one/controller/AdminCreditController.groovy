package com.team.one.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import com.team.one.domain.CreditCommand

@Controller
@RequestMapping("/adminCredit")
class AdminCreditController {

  @PreAuthorize("hasAuthority('ADMIN')")
  @RequestMapping(value="/create",method=RequestMethod.GET)
  String createCreditValuarte(Map model) {
    model.creditCommand = new CreditCommand()
    "adminCredit/form"
  }
}
