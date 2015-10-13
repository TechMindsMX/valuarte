package com.team.one.service

import com.team.one.domain.Simulator

interface OpeningCommissionService {
  BigDecimal calculate(Simulator simulator)
}
