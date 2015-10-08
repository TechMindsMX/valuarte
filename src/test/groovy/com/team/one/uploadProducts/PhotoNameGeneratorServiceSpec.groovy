package com.team.one.uploadProducts

import spock.lang.Specification
import com.team.one.service.impl.PhotoNameGeneratorServiceImpl

class PhotoNameGeneratorServiceSpec extends Specification {

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

  void "should create two images names from sku"() {
    given:"We have two skus and photo numbers is one"
      String sku = "MA004Y07S"
      Integer photoNumber = 2
    when:"We create a name from sku"
      String result = service.getNames(sku, photoNumber)
    then:
      result == "MA004Y07S-1.jpg,MA004Y07S-2.jpg"
  }


}
