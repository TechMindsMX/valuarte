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
    service.cost = 32.48
  }

  void "should get ratio from interest"(){
  given:"Three restructure simulator with interest"
    def restructureRow1 = new SimulatorRow(interest:1062.94)
    def restructureRow2 = new SimulatorRow(interest:721.98)
    def restructureRow3 = new SimulatorRow(interest:367.84)
  and:"Three valuarte simulator with interest"
    def valuarteRow1 = new SimulatorRow(interest:956.65)
    def valuarteRow2 = new SimulatorRow(interest:648.61)
    def valuarteRow3 = new SimulatorRow(interest:329.85)
  and:"A restructure and valuarte row collection"
    def restructure = [restructureRow1, restructureRow2, restructureRow3]
    def valuarte = [valuarteRow1, valuarteRow2, valuarteRow3]
  when:"An reward is calculated"
    def result = service.calculate(restructure, valuarte)
  then:"we expect following results"
    result[0].ratio == 0.49
    result[1].ratio == 0.34
    result[2].ratio == 0.17
  }

  void "should get reward from interest"(){
  given:"Three restructure simulator with interest"
    def restructureRow1 = new SimulatorRow(interest:1062.94)
    def restructureRow2 = new SimulatorRow(interest:721.98)
    def restructureRow3 = new SimulatorRow(interest:367.84)
  and:"Three valuarte simulator with interest"
    def valuarteRow1 = new SimulatorRow(interest:956.65)
    def valuarteRow2 = new SimulatorRow(interest:648.61)
    def valuarteRow3 = new SimulatorRow(interest:329.85)
  and:"A restructure and valuarte row collection"
    def restructure = [restructureRow1, restructureRow2, restructureRow3]
    def valuarte = [valuarteRow1, valuarteRow2, valuarteRow3]
  when:"An reward is calculated"
    def result = service.calculate(restructure, valuarte)
  then:"we expect following results"
    result[0].reward == 91.54
    result[1].reward == 62.07
    result[2].reward == 31.56
  }

  void "should throw an exception when no restructure interest information"(){
  given:"An empty interest collection"
    def rows = []
  and:"Three valuarte simulator with interest"
    def valuarteRow1 = new SimulatorRow(interest:1062.94)
    def valuarteRow2 = new SimulatorRow(interest:721.98)
    def valuarteRow3 = new SimulatorRow(interest:367.84)
  and:"A restructure and valuarte row collection"
    def valuarte = [valuarteRow1, valuarteRow2, valuarteRow3]
  when:"Ratio is calculated"
    service.calculate(rows, valuarte)
  then:"An exception occurred"
    thrown SimulatorException
  }

}
