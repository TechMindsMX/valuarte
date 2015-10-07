package com.team.one.controller

import org.springframework.stereotype.Controller
import org.springframework.security.access.prepost.PreAuthorize
import com.team.one.command.CreditCommand
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder

@Controller
@RequestMapping("/adminCredit")
class AdminCreditController {

  @PreAuthorize("hasAuthority('ADMIN')")
  @RequestMapping(value="/create",method=RequestMethod.GET)
  String createCreditValuarte(Map model) {
    model.creditCommand = new CreditCommand()
    "adminCredit/form"
  }


  @RequestMapping(value="/save", method=RequestMethod.POST)
  String save(CreditCommand command, BindingResult result) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication()
    String name = auth.getName()
    println auth.getPrincipal()
    def address = command.addressCommand.generateAddress()
    def endorsement = command.endorsementCommand.generateEndorsement()
    def financialInfo = command.financialInfoCommand.generateFinancialInfo()
    def references = command.referencesCommand.generateReferences()
    def sure = command.sureCommand.generateSure()
    def transactionalProfile = command.transactionalProfileCommand.generateTransactionalProfile()
    def workInfo = commad.workInfoCommand.generateWorkInfo()
    def client = command.clientCommand.generateClient()
    "adminCredit/form"
  }

}
