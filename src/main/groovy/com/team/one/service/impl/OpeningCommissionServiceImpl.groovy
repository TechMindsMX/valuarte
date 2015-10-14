package com.team.one.service.impl

import com.team.one.domain.Simulator
import com.team.one.service.OpeningCommissionService
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import java.math.RoundingMode

import com.team.one.exception.SimulatorException

@Service
class OpeningCommissionServiceImpl implements OpeningCommissionService {

  @Value('${simulator.decimals}')
  Integer decimals
  @Value('${simulator.roundingMode}')
  String roundingMode

  BigDecimal calculate(Simulator simulator){
    if(!simulator.loan){
      throw new SimulatorException()
    }

    return ((simulator.loan / (1-(simulator.commission/100 * (1 + simulator.iva/100)))) - simulator.loan).setScale(decimals, RoundingMode.valueOf(roundingMode))
  }

}
