package com.team.one.bean

import org.springframework.stereotype.Component
import java.text.SimpleDateFormat

@Component
class DateFormatter{

  String format(Long timestamp){
    def date = new Date(1438975696592L)
    new SimpleDateFormat("yyyy-MM-dd").format(date)
  }

}
