package com.team.one.util

import org.springframework.stereotype.Component
import java.text.SimpleDateFormat

@Component
class DateFormatter{

  String format(Long timestamp){
    def date = new Date(timestamp)
    new SimpleDateFormat("yyyy-MM-dd").format(date)
  }

  String format(Date date){
    new SimpleDateFormat("yyyy-MM-dd").format(date)
  }

}
