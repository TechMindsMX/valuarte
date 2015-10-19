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

  def calculate(def rows){
    if(!rows)
      throw new SimulatorException()

    BigDecimal sum = rows.interest.sum()

    rows.each {
      def ratio = it.interest/sum
      it.ratio = ratio.setScale(decimals, RoundingMode.valueOf(roundingMode))
      it.reward = (ratio * cost).setScale(decimals, RoundingMode.valueOf(roundingMode))
    }

    rows
  }

}
