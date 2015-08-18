package com.team.one.bean

import org.springframework.stereotype.Component

@Component
class DateFormatter{

  String getCurrentDate(){
     new Date()
  }

}
