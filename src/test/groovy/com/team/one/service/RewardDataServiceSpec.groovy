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
    service.cost = 32.48
    service.roundingMode = RoundingMode.HALF_UP
  }

  void "should get ratio from interest"(){
  given:"Three restructure simulator with interest"
    def restructureRow1 = new SimulatorRow(interest:1062.94, capital:10228.78, insurance:77.11, capitalBeforePayment:31888.17)
    def restructureRow2 = new SimulatorRow(interest:721.98, capital:10624.29, insurance:52.37, capitalBeforePayment:21659.39)
    def restructureRow3 = new SimulatorRow(interest:367.84, capital:11035.10, insurance:26.68, capitalBeforePayment:11035.10)
  and:"Three valuarte simulator with interest"
    def valuarteRow1 = new SimulatorRow(interest:956.65)
    def valuarteRow2 = new SimulatorRow(interest:648.61)
    def valuarteRow3 = new SimulatorRow(interest:329.85)
  and:"A result rows"
    def rows = [new SimulatorRow(), new SimulatorRow(), new SimulatorRow()]
  and:"A restructure and valuarte row collection"
    def restructure = [restructureRow1, restructureRow2, restructureRow3]
    def valuarte = [valuarteRow1, valuarteRow2, valuarteRow3]
  when:"An reward is calculated"
    service.calculate(rows, restructure, valuarte)
  then:"we expect following results"
    rows[0].ratio == 0.49
    rows[1].ratio == 0.34
    rows[2].ratio == 0.17
  }

  void "should get reward from interest"(){
  given:"Three restructure simulator with interest"
    def restructureRow1 = new SimulatorRow(interest:1062.94, capital:10228.78, insurance:77.11, capitalBeforePayment:31888.17)
    def restructureRow2 = new SimulatorRow(interest:721.98, capital:10624.29, insurance:52.37, capitalBeforePayment:21659.39)
    def restructureRow3 = new SimulatorRow(interest:367.84, capital:11035.10, insurance:26.68, capitalBeforePayment:11035.10)
  and:"Three valuarte simulator with interest"
    def valuarteRow1 = new SimulatorRow(interest:956.65)
    def valuarteRow2 = new SimulatorRow(interest:648.61)
    def valuarteRow3 = new SimulatorRow(interest:329.85)
  and:"A result rows"
    def rows = [new SimulatorRow(), new SimulatorRow(), new SimulatorRow()]
  and:"A restructure and valuarte row collection"
    def restructure = [restructureRow1, restructureRow2, restructureRow3]
    def valuarte = [valuarteRow1, valuarteRow2, valuarteRow3]
  when:"An reward is calculated"
    service.calculate(rows, restructure, valuarte)
  then:"we expect following results"
    rows[0].reward == 91.54
    rows[1].reward == 62.07
    rows[2].reward == 31.56
  }

  void "should get profit from interest"(){
  given:"Three restructure simulator with interest"
    def restructureRow1 = new SimulatorRow(interest:1062.94, capital:10228.78, insurance:77.11, capitalBeforePayment:31888.17)
    def restructureRow2 = new SimulatorRow(interest:721.98, capital:10624.29, insurance:52.37, capitalBeforePayment:21659.39)
    def restructureRow3 = new SimulatorRow(interest:367.84, capital:11035.10, insurance:26.68, capitalBeforePayment:11035.10)
  and:"Three valuarte simulator with interest"
    def valuarteRow1 = new SimulatorRow(interest:956.65)
    def valuarteRow2 = new SimulatorRow(interest:648.61)
    def valuarteRow3 = new SimulatorRow(interest:329.85)
  and:"A result rows"
    def rows = [new SimulatorRow(), new SimulatorRow(), new SimulatorRow()]
  and:"A restructure and valuarte row collection"
    def restructure = [restructureRow1, restructureRow2, restructureRow3]
    def valuarte = [valuarteRow1, valuarteRow2, valuarteRow3]
  when:"An reward is calculated"
    service.calculate(rows, restructure, valuarte)
  then:"we expect following results"
    rows[0].profit == 971.40
    rows[1].profit == 659.91
    rows[2].profit == 336.28
  }

  void "should get capital cut from capital and insurance"(){
  given:"Three restructure simulator with interest"
    def restructureRow1 = new SimulatorRow(interest:1062.94, capital:10228.78, insurance:77.11, capitalBeforePayment:31888.17)
    def restructureRow2 = new SimulatorRow(interest:721.98, capital:10624.29, insurance:52.37, capitalBeforePayment:21659.39)
    def restructureRow3 = new SimulatorRow(interest:367.84, capital:11035.10, insurance:26.68, capitalBeforePayment:11035.10)
  and:"Three valuarte simulator with interest"
    def valuarteRow1 = new SimulatorRow(interest:956.65)
    def valuarteRow2 = new SimulatorRow(interest:648.61)
    def valuarteRow3 = new SimulatorRow(interest:329.85)
  and:"A result rows"
    def rows = [new SimulatorRow(), new SimulatorRow(), new SimulatorRow()]
  and:"A restructure and valuarte row collection"
    def restructure = [restructureRow1, restructureRow2, restructureRow3]
    def valuarte = [valuarteRow1, valuarteRow2, valuarteRow3]
  when:"An reward is calculated"
    service.calculate(rows, restructure, valuarte)
  then:"we expect following results"
    rows[0].capitalCut == 10151.67
    rows[1].capitalCut == 10571.92
    rows[2].capitalCut == 11008.42
  }

  void "should get balance from capital before payment and reward"(){
  given:"Three restructure simulator with interest"
    def restructureRow1 = new SimulatorRow(interest:1062.94, capital:10228.78, insurance:77.11, capitalBeforePayment:31888.17)
    def restructureRow2 = new SimulatorRow(interest:721.98, capital:10624.29, insurance:52.37, capitalBeforePayment:21659.39)
    def restructureRow3 = new SimulatorRow(interest:367.84, capital:11035.10, insurance:26.68, capitalBeforePayment:11035.10)
  and:"Three valuarte simulator with interest"
    def valuarteRow1 = new SimulatorRow(interest:956.65)
    def valuarteRow2 = new SimulatorRow(interest:648.61)
    def valuarteRow3 = new SimulatorRow(interest:329.85)
  and:"A result rows"
    def rows = [new SimulatorRow(), new SimulatorRow(), new SimulatorRow()]
  and:"A restructure and valuarte row collection"
    def restructure = [restructureRow1, restructureRow2, restructureRow3]
    def valuarte = [valuarteRow1, valuarteRow2, valuarteRow3]
  when:"An reward is calculated"
    service.calculate(rows, restructure, valuarte)
  then:"we expect following results"
    rows[0].balance == 21736.50
    rows[1].balance == 11087.47
    rows[2].balance == 26.68
  }

  void "should throw an exception when no restructure interest information"(){
  given:"An empty interest collection"
    def rows = []
  and:"Three valuarte simulator with interest"
    def valuarteRow1 = new SimulatorRow(interest:1062.94)
    def valuarteRow2 = new SimulatorRow(interest:721.98)
    def valuarteRow3 = new SimulatorRow(interest:367.84)
  and:"A result rows"
    def result = [new SimulatorRow(), new SimulatorRow(), new SimulatorRow()]
  and:"A restructure and valuarte row collection"
    def valuarte = [valuarteRow1, valuarteRow2, valuarteRow3]
  when:"Ratio is calculated"
    service.calculate(result, rows, valuarte)
  then:"An exception occurred"
    thrown SimulatorException
  }

  void "should throw an exception when no valuarte interest information"(){
  given:"An empty interest collection"
    def rows = []
  and:"Three valuarte simulator with interest"
    def restructureRow1 = new SimulatorRow(interest:1062.94)
    def restructureRow2 = new SimulatorRow(interest:721.98)
    def restructureRow3 = new SimulatorRow(interest:367.84)
  and:"A result rows"
    def result = [new SimulatorRow(), new SimulatorRow(), new SimulatorRow()]
  and:"A restructure and valuarte row collection"
    def restructure = [restructureRow1, restructureRow2, restructureRow3]
  when:"Ratio is calculated"
    service.calculate(result, restructure, rows)
  then:"An exception occurred"
    thrown SimulatorException
  }

}
