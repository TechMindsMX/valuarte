package com.team.one.repository

import com.team.one.domain.*
import org.springframework.data.repository.PagingAndSortingRepository

interface CostHealthInsurenceRepository extends PagingAndSortingRepository<CostHealthInsurence,Long> {

  CostHealthInsurence findByOptionPackAndSexAndAge(String optionPack,String sex,Integer age)

}
