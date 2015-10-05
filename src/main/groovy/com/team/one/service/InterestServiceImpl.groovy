package com.team.one.service

import org.springframework.beans.factory.annotation.Value
import java.math.RoundingMode
import com.team.one.domain.Simulator
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import com.team.one.exception.SimulatorException

@Service
class InterestServiceImpl implements InterestService {

  @Value('${simulator.decimals}')
  Integer decimals
  @Value('${simulator.roundingMode}')
  String roundingMode

  BigDecimal calculate(BigDecimal capitalBeforePayment, Simulator simulator){
    if(!capitalBeforePayment || !simulator?.tia)
      return 0

    if(!simulator.paymentPeriod) {
      throw new SimulatorException()
    }

    BigDecimal result = 0
    result = capitalBeforePayment * simulator.tia / 12 / 100 / simulator.paymentPeriod.factor
    result.setScale(decimals, RoundingMode.valueOf(roundingMode))
  }

}
