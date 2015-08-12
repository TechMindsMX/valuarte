package com.team.one.util

class PhotoNameGenerator {

  String getNames(String sku, Integer photoNumber) {
    def sb = new StringBuilder()
    (0..photoNumber-1).each{
      sb.append("${sku}-"it)
    }
    sb
  }

}
