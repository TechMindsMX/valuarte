package com.team.one.collaborator

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import com.team.one.domain.Simulator
import com.team.one.service.PMTService
import com.team.one.service.InsuranceService
import com.team.one.service.SimulatorService
import com.team.one.service.OpeningCommissionService
import com.team.one.domain.PaymentPeriod
import com.team.one.exception.SimulatorException

//TODO: Externalizar los mensajes de error

@Component
class SimulatorCollaborator {

  @Autowired
  PMTService pmtService
  @Autowired
  InsuranceService insuranceService
  @Autowired
  OpeningCommissionService openingCommissionService

  def calculate(Simulator simulator){
    if(!simulator.paymentPeriod){
      throw new SimulatorException('Es necesario incluir un periodo de pago para el cálculo')
    }

    simulator.openingCommission = openingCommissionService.calculate(simulator)
    simulator.lifeInsurance = insuranceService.calculate(simulator)
    simulator.principle = simulator.loan + simulator.lifeInsurance + simulator.openingCommission
    simulator.payment = pmtService.calculate(simulator)

    simulator
  }

}
