package com.team.one.service.impl

import com.team.one.domain.Simulator
import com.team.one.service.InsuranceService
import com.team.one.service.InsuranceDataService
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import org.springframework.beans.factory.annotation.Autowired
import com.team.one.exception.SimulatorException

@Service
class InsuranceServiceImpl implements InsuranceService {

  @Autowired
  InsuranceDataService insuranceDataService

  BigDecimal calculate(Simulator simulator){
    if(!simulator.loan)
      throw new SimulatorException()

    def insurances = insuranceDataService.calculate(simulator)
    insurances.sum()
  }

}
