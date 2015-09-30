package com.team.one.service

import com.team.one.domain.SimulatorCommand
import com.team.one.domain.Simulator
import com.team.one.domain.Client

class DataBinderServiceImpl implements DataBinderService {

  Simulator bindSimulator(SimulatorCommand command){
    def commandProperties = command.properties.findAll { k, v ->
      Simulator.metaClass.getProperties()*.name.contains(k) && k != "class"
    }
    new Simulator(commandProperties)
  }

  Client bindClient(SimulatorCommand command){
    def commandProperties = command.properties.findAll { k, v ->
      Client.metaClass.getProperties()*.name.contains(k) && k != "class"
    }
    new Client(commandProperties)
  }


}

