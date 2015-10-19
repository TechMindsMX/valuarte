package com.team.one.util

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.math.RoundingMode

@Component
class NumberFormatter {

  @Value('${simulator.roundingMode}')
  String roundingMode

  String format(BigDecimal number){
    number.setScale(2, RoundingMode.valueOf(roundingMode))
  }

}
