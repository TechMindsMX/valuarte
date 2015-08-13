package com.team.one.service.uploadProducts

class PhotoNameGeneratorServiceImpl implements PhotoNameGeneratorService {

  String getNames(String sku, Integer photoNumber) {
    def sb = new StringBuilder()
    (0..photoNumber-1).each{ number ->
      sb.append("${sku}-${number+1},")
    }
    sb.toString()
  }

}


