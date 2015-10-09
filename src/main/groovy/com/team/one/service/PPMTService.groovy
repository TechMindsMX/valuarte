package com.team.one.service

import com.team.one.domain.Simulator

interface PPMTService {
  BigDecimal calculate(Simulator simulator, BigDecimal base, Integer numberPayment)
}
