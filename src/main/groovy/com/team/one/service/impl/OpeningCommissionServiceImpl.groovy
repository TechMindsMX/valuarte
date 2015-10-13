package com.team.one.service.impl

import com.team.one.domain.Simulator
import com.team.one.service.InsuranceService
import com.team.one.service.InsuranceDataService
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import org.springframework.beans.factory.annotation.Autowired
import com.team.one.exception.SimulatorException

@Service
class OpeningCommissionServiceImpl implements OpeningCommissionService {

  BigDecimal calculate(Simulator simulator){
    return 0
  }

}
