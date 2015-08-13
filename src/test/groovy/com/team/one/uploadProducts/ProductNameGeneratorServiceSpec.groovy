package com.team.one.uploadProducts

import spock.lang.Specification
import com.team.one.service.uploadProducts.PhotoNameGeneratorServiceImpl

class ProductNameGeneratorServiceSpec extends Specification {

  PhotoNameGeneratorServiceImpl service = new PhotoNameGeneratorServiceImpl()

  void "should create an image name from sku"() {
    given:"We have an sku and photo numbers is one"
      String sku = "MA004Y07S"
      Integer photoNumber = 1
    when:"We create a name from sku"
      String result = service.getNames(sku, photoNumber)
    then:
      result == "MA004Y07S-1.jpg"
  }

}
