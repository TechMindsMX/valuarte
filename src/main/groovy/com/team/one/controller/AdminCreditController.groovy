package com.team.one.controller

import org.springframework.stereotype.Controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import com.team.one.command.CreditCommand
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import com.team.one.domain.*
import org.springframework.ui.Model
import com.team.one.service.AdminCreditService
import com.team.one.repository.UserRepository

@Controller
@RequestMapping("/adminCredit")
class AdminCreditController {

  @Autowired
  AdminCreditService service
  @Autowired
  UserRepository userRepository

  @PreAuthorize("hasAuthority('ADMIN')")
  @RequestMapping(value="/create",method=RequestMethod.GET)
  String createCreditValuarte(Map model) {
    model.creditCommand = new CreditCommand()
    model.date = new Date().format("dd-MMM-yyyy")
    "adminCredit/form"
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @RequestMapping(value="/save", method=RequestMethod.POST)
  String save(CreditCommand command, BindingResult result,Model model) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication()
    String userCreate = auth.getName()
    def address = command.addressCommand.generateAddress()
    def endorsement = command.endorsementCommand.generateEndorsement()
    def financialInfo = command.financialInfoCommand.generateFinancialInfo()
    def references = command.referencesCommand.generateReferences()
    def transactionalProfile = command.transactionalProfileCommand.generateTransactionalProfile()
    def workInfo = command.workInfoCommand.generateWorkInfo()
    def client = command.clientCommand.generateClient()
    def user = userRepository.findByEmail(address.email)
    def owner
    def pld =  command.pldInterview.generatePLDInterview()
    if (command.ownerCommand)
      owner = command.ownerCommand.generateOwnerIdentification()
    Map domainList = [
                        address:address,
                        endorsement:endorsement,
                        financial:financialInfo,
                        reference:references,
                        transactional:transactionalProfile,
                        work:workInfo,
                        owner:owner,
                        pld:pld,
                        client:client
                      ]

    def clientPersistence = service.create(domainList,userCreate)
    model.clientUuid = clientPersistence
    "adminCredit/form"
  }

}
