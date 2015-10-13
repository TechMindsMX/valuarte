package com.team.one.service.impl

import com.team.one.service.DocumentService
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.util.*
import com.team.one.repository.*
import com.lowagie.text.DocumentException
import org.xhtmlrenderer.pdf.ITextRenderer

@Service
class DocumentServiceImpl implements DocumentService {

  @Autowired
  UserRepository userRepository
  @Autowired
  ClientRepository clientRepository
  @Value('${timOne.path.documents.locations}')
  String documentLocation


  def createDocumentStartedKit(def client, def documentName){
    def engine = new groovy.text.SimpleTemplateEngine()
    def file = new File(documentLocation+""+documentName)
    def text = file.text

    def xhtmlWrite = new StringWriter()
    engine.createTemplate(text).make(client.properties).writeTo(xhtmlWrite)
    def xhtml = xhtmlWrite.toString()
    xhtmlWrite.close()
    
    ITextRenderer renderer = new ITextRenderer()
    renderer.setDocumentFromString(xhtml)
    renderer.layout()

    def temporalFile = File.createTempFile(System.currentTimeMillis().toString(),".pdf")
    OutputStream os = new FileOutputStream(temporalFile)
    renderer.createPDF(os)
    temporalFile

  }

}
