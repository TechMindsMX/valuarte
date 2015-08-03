package com.team.one.domain

import org.hibernate.validator.constraints.NotEmpty
import javax.validator.constraints.NotNull

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
