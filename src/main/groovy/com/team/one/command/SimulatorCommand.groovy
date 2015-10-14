package com.team.one.command

import com.team.one.domain.PaymentPeriod

import javax.validation.constraints.DecimalMin
import javax.validation.constraints.NotNull
import javax.validation.constraints.Min
import com.team.one.domain.Simulator
import com.team.one.domain.Client

class SimulatorCommand {

  String rfc
  String nombre
  String apellidoPaterno
  String apellidoMaterno
  Date now

  BigDecimal commission
  BigDecimal payment
  BigDecimal principle
  BigDecimal openingCommission
  BigDecimal lifeInsurance = 0

  PaymentPeriod paymentPeriod
  String paydays
  Date startDate

  @NotNull
  @DecimalMin(value="0.01", inclusive=true)
  BigDecimal tia

  @NotNull
  @DecimalMin(value="0.01", inclusive=true)
  BigDecimal iva

  @NotNull
  @DecimalMin(value="0.01", inclusive=true)
  BigDecimal loan

  @NotNull
  @Min(1L)
  Integer numberOfPayments


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
