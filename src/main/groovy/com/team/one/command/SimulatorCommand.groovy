package com.team.one.command

import com.team.one.domain.PaymentPeriod

import javax.validation.constraints.DecimalMin
import javax.validation.constraints.NotNull
import javax.validation.constraints.Min

import com.team.one.domain.Simulator
import com.team.one.domain.Client
import com.team.one.domain.enums.SimulatorType

class SimulatorCommand {

  String rfc
  String nombre
  String apellidoPaterno
  String apellidoMaterno
  Boolean saved
  Date now

  BigDecimal payment
  BigDecimal principle
  BigDecimal openingCommission
  BigDecimal lifeInsurance = 0

  PaymentPeriod paymentPeriod
  SimulatorType type = SimulatorType.RESTRUCTURE

  String paydays
  Date startDate

  @NotNull
  @DecimalMin(value="36", inclusive=true)
  BigDecimal tia = 0

  @NotNull
  @DecimalMin(value="0.01", inclusive=true)
  BigDecimal iva = 0

  @NotNull
  @DecimalMin(value="0.01", inclusive=true)
  BigDecimal loan

  @NotNull
  @DecimalMin(value="0.00", inclusive=true)
  BigDecimal commission = 0

  @NotNull
  @Min(1L)
  Integer numberOfPayments = 0


  Simulator bindSimulator(){
    def commandProperties = this.properties.findAll { k, v ->
      Simulator.metaClass.getProperties()*.name.contains(k) && k != "class"
    }
    new Simulator(commandProperties)
  }

  Client bindClient(){
    def commandProperties = this.properties.findAll { k, v ->
      Client.metaClass.getProperties()*.name.contains(k) && k != "class"
    }
    new Client(commandProperties)
  }

}
