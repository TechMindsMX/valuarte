package com.team.one.service

import com.team.one.service.impl.RewardDataServiceImpl
import com.team.one.domain.SimulatorRow
import com.team.one.exception.SimulatorException

import java.math.RoundingMode
import spock.lang.Specification

class RewardDataServiceSpec extends Specification {

  RewardDataServiceImpl service = new RewardDataServiceImpl()

  def setup(){
    service.decimals = 2
    service.roundingMode = RoundingMode.HALF_UP
  }

  void "should get ratio from interest"(){
  given:"Three simulator rows with interest"
    def simulatorRow1 = new SimulatorRow(interest:1062.94)
    def simulatorRow2 = new SimulatorRow(interest:721.98)
    def simulatorRow3 = new SimulatorRow(interest:367.84)
  and:"A Simulator row collection"
    def rows = [simulatorRow1, simulatorRow2, simulatorRow3]
  when:"An reward is calculated"
    def result = service.calculate(rows)
  then:"we expect following results"
    result[0].ratio == 0.49
    result[1].ratio == 0.34
    result[2].ratio == 0.17
  }

  void "should throw an exception when no interest information"(){
  given:"An empty interest collection"
    def rows = []
  when:"Ratio is calculated"
    service.calculate(rows)
  then:"An exception occurred"
    thrown SimulatorException
  }

}
