package com.team.one.service

import com.team.one.domain.SimulatorCommand
import com.team.one.domain.Simulator

class DataBinderServiceImpl implements DataBinderService {

  Simulator bind(SimulatorCommand command){
    def commandProperties = command.properties.findAll { k, v ->
      Simulator.metaClass.getProperties()*.name.contains(k) && k != "class"
    }
    new Simulator(commandProperties)
  }

}

