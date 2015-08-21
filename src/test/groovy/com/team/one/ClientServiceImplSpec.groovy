package com.team.one

import org.junit.Test
import org.junit.runner.RunWith
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

import com.team.one.service.ClientServiceImpl

class ClientServiceImplSpec extends Specification {

  ClientServiceImpl rest = new ClientServiceImpl()

  void "obtain a error in call rest service"() {
    when:
      def resp = rest.createProductTramaPost([])
    then:
      println resp
  }

}
