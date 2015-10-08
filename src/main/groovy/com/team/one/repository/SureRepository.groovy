package com.team.one.repository

import com.team.one.domain.Sure
import org.springframework.data.repository.PagingAndSortingRepository

interface SureRepository extends PagingAndSortingRepository<Sure,Long> {

  Sure findById(Long id)

}
