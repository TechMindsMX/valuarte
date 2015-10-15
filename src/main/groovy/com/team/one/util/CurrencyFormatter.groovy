package com.team.one.util

import org.springframework.stereotype.Component
import java.text.NumberFormat

@Component
class CurrencyFormatter {

  String format(BigDecimal number){
    NumberFormat formatter = NumberFormat.getCurrencyInstance()
    formatter.format(number)
  }

}
