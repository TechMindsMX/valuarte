package com.team.one.service.impl

import com.team.one.service.DocumentService
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.util.*
import com.team.one.repository.*

@Service
class DocumentServiceImpl implements DocumentService {

  @Autowired
  UserRepository userRepository
  @Autowired
  ClientRepository clientRepository

  def createDocumentStartedKit(def userCommand){}

  /*private def getInformationofClient(String username) {
    def user = userRepository.findByUsername(username)
    def client = clientRepository
  }*/

}
