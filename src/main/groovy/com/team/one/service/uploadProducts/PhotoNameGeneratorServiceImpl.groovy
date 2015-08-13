package com.team.one.service.uploadProducts

import org.springframework.stereotype.*

@Service
class PhotoNameGeneratorServiceImpl implements PhotoNameGeneratorService {

  String getNames(String sku, Integer photoNumber) {
    def sb = new StringBuilder()
    (0..photoNumber-1).each{ number ->
      sb.append("${sku}-${number+1}.jpg,")
    }
    sb.toString()[0..-2]
  }

}


