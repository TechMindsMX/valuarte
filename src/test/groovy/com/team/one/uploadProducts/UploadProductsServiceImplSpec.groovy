package com.team.one.uploadProducts

import org.junit.Test
import org.junit.runner.RunWith
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import org.springframework.mock.web.MockMultipartFile
import java.io.InputStream

import com.team.one.service.uploadProducts.UploadProductsServiceImpl

class UploadProductsServiceImplSpec extends Specification {

  UploadProductsServiceImpl uploadP = new UploadProductsServiceImpl()

  void "obtains all values of excel"() {
    when:
      FileInputStream inputFile = new FileInputStream( "/Users/says/Documents/mabe.xls")
      MockMultipartFile file = new MockMultipartFile("file", "NameOfTheFile", "multipart/form-data", inputFile)
      def count = uploadP.uploadProductsInValuarte(file)
    then:
      count == 4
  }

}
