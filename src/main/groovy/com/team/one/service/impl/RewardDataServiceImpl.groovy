package com.team.one.service.impl

import org.springframework.beans.factory.annotation.Value
import java.math.RoundingMode

import com.team.one.service.RewardDataService
import com.team.one.exception.SimulatorException
import com.team.one.domain.Simulator

class RewardDataServiceImpl implements RewardDataService {

  @Value('${simulator.decimals}')
  Integer decimals
  @Value('${simulator.roundingMode}')
  String roundingMode

  def calculate(def rows){
    if(!rows)
      throw new SimulatorException()

    BigDecimal sum = rows.interest.sum()

    rows.each {
      it.ratio = (it.interest/sum).setScale(decimals, RoundingMode.valueOf(roundingMode))
    }

    rows
  }

}
