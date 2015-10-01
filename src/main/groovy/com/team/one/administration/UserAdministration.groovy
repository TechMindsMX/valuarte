package com.team.one.administration

import org.lightadmin.api.config.AdministrationConfiguration
import org.lightadmin.api.config.builder.EntityMetadataConfigurationUnitBuilder
import org.lightadmin.api.config.unit.EntityMetadataConfigurationUnit
import com.team.one.domain.User

class UserAdministration extends AdministrationConfiguration<User> {

  @Override
  EntityMetadataConfigurationUnit configuration(EntityMetadataConfigurationUnitBuilder configurationBuilder) {
    configurationBuilder.nameField("username").singularName("User").pluralName("Users").build()
  }

}
