package com.team.one.service.impl

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.team.one.domain.Simulator
import com.team.one.service.PPMTService
import com.team.one.service.InsuranceDataService
import org.springframework.stereotype.Service
import com.team.one.domain.SimulatorRow
import java.math.RoundingMode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import com.team.one.exception.SimulatorException

@Service
class InsuranceDataServiceImpl implements InsuranceDataService {

  @Autowired
  PPMTService ppmtService

  @Value('${simulator.decimals}')
  Integer decimals
  @Value('${simulator.roundingMode}')
  String roundingMode

  Logger log = LoggerFactory.getLogger(getClass());

  def calculate(Simulator simulator){
    def rows = []
    if(!simulator.numberOfPayments || simulator.numberOfPayments < 0)
      throw new SimulatorException()

    def capitalBeforePayment = simulator.loan
    def capitalAfterPayment = new BigDecimal()
    def capital = new BigDecimal()

    (1..simulator.numberOfPayments).each { n ->
      def insurance = new BigDecimal()
      capital = ppmtService.calculate(simulator, simulator.loan, simulator.numberOfPayments - (n-1))
      data.capitalAfterPayment = (capitalBeforePayment - data.capital).setScale(decimals, RoundingMode.valueOf(roundingMode))
      capitalBeforePayment = (capitalBeforePayment - data.capital).setScale(decimals, RoundingMode.valueOf(roundingMode))
      rows.add(insurance)
    }
    rows
  }

}
