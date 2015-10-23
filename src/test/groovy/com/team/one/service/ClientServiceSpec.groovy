package com.team.one.service

import com.team.one.domain.Client
import com.team.one.repository.ClientRepository
import com.team.one.service.impl.ClientServiceImpl

import spock.lang.Specification

class ClientServiceSpec extends Specification {

  ClientServiceImpl service = new ClientServiceImpl()

  def clientRepository = Mock(ClientRepository)

  def setup(){
    service.clientRepository = clientRepository
  }

  void "should get client by rfc"(){
    given:"An rfc"
      String rfc='rfc'
    and:"A Client"
      def client = new Client()
    when:"We search by rfc"
      clientRepository.findByRfc(rfc) >> client
      def result = service.findByRfc(rfc)
    then:"We expect client"
      result == client
  }

}
