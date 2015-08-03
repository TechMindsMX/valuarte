package com.team.one.uploadProducts

import org.junit.Test
import org.junit.runner.RunWith
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import org.springframework.mock.web.MockMultipartFile

import com.team.one.service.uploadProducts.UploadProductsServiceImpl

class UploadProductsServiceImplSpec extends Specification {

  UploadProductsServiceImpl uploadP = new UploadProductsServiceImpl()

  void "obtains all values of excel"() {
    when:
      MockMultipartFile file = new MockMultipartFile("/Users/says/Documents/mabe.xls")
      println file.dump()
      def count = uploadP.uploadProductsInValuarte(file)
    then:
      count == 4
  }

}
