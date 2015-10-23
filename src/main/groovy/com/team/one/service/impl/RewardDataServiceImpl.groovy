package com.team.one.service.impl

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.math.RoundingMode

import com.team.one.service.RewardDataService
import com.team.one.domain.Simulator
import com.team.one.exception.SimulatorException

@Service
class RewardDataServiceImpl implements RewardDataService {

  @Value('${simulator.decimals}')
  Integer decimals
  @Value('${simulator.roundingMode}')
  String roundingMode
  @Value('${simulator.cost}')
  BigDecimal cost

  def calculate(def restructure, def valuarte){
    if(!restructure || !valuarte)
      throw new SimulatorException()

    BigDecimal restructureSum = restructure.interest.sum()
    BigDecimal valuarteSum = valuarte.interest.sum()
    BigDecimal totalReward = restructureSum - valuarteSum - cost

    restructure.each { row ->
      def ratio = row.interest/valuarteSum
      row.ratio = ratio.setScale(decimals, RoundingMode.valueOf(roundingMode))
      row.reward = (ratio * totalReward).setScale(decimals, RoundingMode.valueOf(roundingMode))
    }

    valuarte.each { row ->
      def ratio = row.interest/valuarteSum
      row.ratio = ratio.setScale(decimals, RoundingMode.valueOf(roundingMode))
      row.reward = (ratio * totalReward).setScale(decimals, RoundingMode.valueOf(roundingMode))
    }

  }

}
