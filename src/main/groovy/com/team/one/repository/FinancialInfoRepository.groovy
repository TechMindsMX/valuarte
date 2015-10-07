package com.team.one.repository

import com.team.one.domain.FinancialInfo
import org.springframework.data.repository.PagingAndSortingRepository

interface FinancialInfoRepository extends PagingAndSortingRepository<FinancialInfo, Long> {

  FinancialInfo findById(Long id)

}

