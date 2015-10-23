package com.team.one.service

import com.team.one.domain.Client
import com.team.one.service.impl.ClientServiceImpl

import spock.lang.Specification

class ClientServiceSpec extends Specification {

  ClientServiceImpl service = new ClientServiceImpl()

  void "should get client by rfc"(){
    given:"An rfc"
      String rfc='rfc'
    when:"We search by rfc"
      def result = service.findByRfc(rfc)
    then:"We expect client"
      result
  }

}
