package com.team.one.service

import com.team.one.domain.SimulatorCommand
import com.team.one.domain.Simulator
import com.team.one.domain.Client

interface DataBinderService {

  Simulator bindSimulator(SimulatorCommand command)
  Client bindClient(SimulatorCommand command)

}

