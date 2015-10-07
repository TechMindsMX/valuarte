package com.team.one.command

import org.hibernate.validator.constraints.NotEmpty
import javax.validation.constraints.NotNull

class ProductCommand {

  @NotEmpty
  Integer sku

  @NotEmpty
  Integer price

  @NotEmpty
  String description

  @Override
  String toString() {
    "${sku} - ${description}"
  }
}
