package com.team.one.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.beans.factory.annotation.*
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import org.springframework.util.FileCopyUtils

import com.team.one.service.DocumentService
import com.team.one.repository.ClientRepository
import org.springframework.ui.Model

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
@RequestMapping("/startKit")
class DocumentsStartedKitController {

  @Autowired
  DocumentService documentService
  @Autowired
  ClientRepository repository
  @Value('${valuarte.document.list.names}')
  def listDocuments

  @PreAuthorize("hasAuthority('ADMIN')")
  @RequestMapping(value="/create", method=RequestMethod.GET, produces =  "application/pdf")
  @ResponseBody
  byte[] createStartedKitOfCredit(String uuid) {
    def client = repository.findByUuid(uuid.toString())
    def file = documentService.createDocumentStartedKit(client,listDocuments)
    file.bytes
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @RequestMapping(value="/show",method=RequestMethod.GET)
  def showAllClients(Model model) {
    model.addAttribute("clients",repository.findAll())
    "client/show"
  }

}
