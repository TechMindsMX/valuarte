package com.team.one.repository

import com.team.one.domain.WorkInfo
import org.springframework.data.repository.PagingAndSortingRepository

interface WorkInfoRepository extends PagingAndSortingRepository<WorkInfo,Long> {

  WorkInfo findById(Long id)

}
