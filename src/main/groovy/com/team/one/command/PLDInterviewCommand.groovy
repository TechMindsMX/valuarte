package com.team.one.command

import com.team.one.domain.PLDInterview

class PLDInterviewCommand {

  String gobierno
  String consanguineo
  String ingresos
  BigDecimal monto

  PLDInterview generatePLDInterview() {
    new PLDInterview(
      gobierno: this.gobierno,
      consanguimeo: this.consanguineo,
      ingresos: this.ingresos,
      monto: this.monto
    )
  }

}
