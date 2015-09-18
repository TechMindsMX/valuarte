package com.team.one.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import org.springframework.util.FileCopyUtils

import com.team.one.service.DocumentService

@Controller
@RequestMapping("/startKit")
class DocumentsStartedKitController {

  @Autowired
  DocumentService documentService
    
  @PreAuthorize("hasAuthority('ADMIN')")
  @RequestMapping(value="/create", method=RequestMethod.GET)
  def createStartedKitOfCredit(def username) {
    def file = documentService.createDocumentStartedKit(username)
    def fis = new FileInputStream(file)
    response.setContentType("application/pdf")
    response.setContentLength(((int) file.size()))
    response.setHeader("Content-Disposition","attachment filename=\"" + file.name +"\"")
    FileCopyUtils.copy(fis, response.getOutputStream())
  }

}