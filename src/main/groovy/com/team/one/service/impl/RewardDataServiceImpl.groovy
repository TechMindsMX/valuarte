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

  def calculate(def rows, def restructure, def valuarte){
    if(!restructure || !valuarte)
      throw new SimulatorException()

    BigDecimal restructureSum = restructure.interest.sum()
    BigDecimal valuarteSum = valuarte.interest.sum()
    BigDecimal totalReward = restructureSum - valuarteSum - cost

    valuarte.eachWithIndex { row, index ->
      def ratio = row.interest/valuarteSum
      def reward = ratio * totalReward
      rows[index].ratio = ratio.setScale(decimals, RoundingMode.valueOf(roundingMode))
      rows[index].reward = reward.setScale(decimals, RoundingMode.valueOf(roundingMode))
      rows[index].profit = (restructure[index].interest - reward).setScale(decimals, RoundingMode.valueOf(roundingMode))
      rows[index].capitalCut = (restructure[index].capital - restructure[index].insurance).setScale(decimals, RoundingMode.valueOf(roundingMode))
    }
  }

}
