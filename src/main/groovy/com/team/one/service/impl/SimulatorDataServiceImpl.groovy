package com.team.one.service.impl

import com.team.one.domain.Simulator
import com.team.one.service.DatePaymentService
import com.team.one.service.InterestService
import com.team.one.service.PPMTService
import com.team.one.service.InsuranceDataService
import com.team.one.service.SimulatorDataService
import org.springframework.stereotype.Service
import java.math.RoundingMode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value

import com.team.one.domain.SimulatorRow
import com.team.one.exception.SimulatorException

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Service
class SimulatorDataServiceImpl implements SimulatorDataService {

  @Autowired
  DatePaymentService datePaymentService
  @Autowired
  InterestService interestService
  @Autowired
  PPMTService ppmtService
  @Autowired
  InsuranceDataService insuranceDataService

  @Value('${simulator.decimals}')
  Integer decimals
  @Value('${simulator.roundingMode}')
  String roundingMode

  Logger log = LoggerFactory.getLogger(getClass())

  def calculate(Simulator simulator){
    def rows = []
    if(!simulator.numberOfPayments || simulator.numberOfPayments < 0)
      throw new SimulatorException()

    def capitalBeforePayment = simulator.principle
    def paymentDates = datePaymentService.generatePaymentDates(simulator)
    def insurances = insuranceDataService.calculate(simulator)

    (1..simulator.numberOfPayments).each { n ->
      def data = new SimulatorRow()
      data.number = n
      data.capital = ppmtService.calculate(simulator, simulator.principle, simulator.numberOfPayments - (n-1))
      data.interest = interestService.calculate(capitalBeforePayment, simulator)
      data.capitalBeforePayment = capitalBeforePayment
      data.capitalAfterPayment = (capitalBeforePayment - data.capital).setScale(decimals, RoundingMode.valueOf(roundingMode))
      capitalBeforePayment = (capitalBeforePayment - data.capital).setScale(decimals, RoundingMode.valueOf(roundingMode))
      data.paymentDate = paymentDates.get(n-1)
      data.iva = (data.interest * simulator.iva / 100).setScale(decimals, RoundingMode.valueOf(roundingMode))
      data.insurance = insurances.get(n-1)
      rows.add(data)
    }
    rows
  }

}
