package com.team.one.service.impl

import com.team.one.command.SimulatorCommand
import com.team.one.domain.Simulator
import com.team.one.domain.Client
import com.team.one.service.DataBinderService
import org.springframework.stereotype.Service

@Service
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

