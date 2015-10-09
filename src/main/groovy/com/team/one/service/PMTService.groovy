package com.team.one.service

import com.team.one.domain.Simulator

interface PMTService {
  BigDecimal calculate(Simulator simulator)
}
