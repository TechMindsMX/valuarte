package com.team.one.service

import com.team.one.service.impl.RewardDataServiceImpl

import java.math.RoundingMode
import spock.lang.Specification

class RewardDataServiceSpec extends Specification {

  RewardDataServiceImpl service = new RewardDataServiceImpl()

  def setup(){
    service.decimals = 2
    service.roundingMode = RoundingMode.HALF_UP
  }

  void "should get ratio from interest"(){
  given:"We have an inteteres collection"
    def interests = [1075.60, 1003.47, 928.54, 850.73, 769.90, 685.94, 598.94, 508.17, 414.10, 316.39, 214.90, 109.49]
  when:"An reward is calculated"
    def result = service.calculate(interests)
  then:"we expect following results"
    result == [0.14, 0.13, 0.12, 0.11, 0.10, 0.09, 0.08, 0.07, 0.06, 0.04, 0.03, 0.01]
  }

}
