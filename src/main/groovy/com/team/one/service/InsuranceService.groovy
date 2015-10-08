package com.team.one.service

import com.team.one.domain.Simulator

interface InsuranceService {
  BigDecimal calculate(Simulator simulator)
}
