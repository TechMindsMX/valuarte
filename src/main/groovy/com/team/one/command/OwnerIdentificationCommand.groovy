package com.team.one.command

import com.team.one.domain.OwnerIdentification

class OwnerIdentificationCommand {

  String actuar
  String recursos
  String aportaciones

  OwnerIdentification generateOwnerIdentification() {
    new OwnerIdentification (
      actuar: this.actuar,
      recursos: this.recursos,
      aportaciones: this.aportaciones
    )
  }

}
