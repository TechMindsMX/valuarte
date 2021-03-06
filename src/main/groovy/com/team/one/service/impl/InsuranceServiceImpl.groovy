package com.team.one.service.impl

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.team.one.domain.Simulator
import com.team.one.service.InsuranceService
import com.team.one.service.InsuranceDataService
import org.springframework.stereotype.Service
import com.team.one.domain.PaymentPeriod
import org.springframework.beans.factory.annotation.Autowired
import com.team.one.exception.SimulatorException

//TODO: Externalizar los mensajes de error

@Service
class InsuranceServiceImpl implements InsuranceService {

  @Autowired
  InsuranceDataService insuranceDataService

  Logger log = LoggerFactory.getLogger(getClass());

  BigDecimal calculate(Simulator simulator){
    if(!simulator.loan)
      throw new SimulatorException('No se ha proporcionado el monto de préstamo base')

    def insurances = insuranceDataService.calculate(simulator)
    insurances.sum()
  }

}
