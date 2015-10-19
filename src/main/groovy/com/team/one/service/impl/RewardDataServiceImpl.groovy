package com.team.one.service.impl

import org.springframework.beans.factory.annotation.Value
import java.math.RoundingMode

import com.team.one.service.RewardDataService
import com.team.one.domain.Simulator

class RewardDataServiceImpl implements RewardDataService {

  @Value('${simulator.decimals}')
  Integer decimals
  @Value('${simulator.roundingMode}')
  String roundingMode

  def calculate(def rows){
    def ratios = []
    BigDecimal sum = rows.sum()

    rows.each {
      ratios.add((it/sum).setScale(decimals, RoundingMode.valueOf(roundingMode)))
    }

    ratios
  }

}
