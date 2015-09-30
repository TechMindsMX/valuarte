package com.team.one.service

import com.team.one.domain.SimulatorCommand
import com.team.one.domain.Simulator

interface DataBinderService {

  Simulator bind(SimulatorCommand command)

}

