package com.team.one.repository

import com.team.one.domain.PLDInterview
import org.springframework.data.repository.PagingAndSortingRepository

interface PLDInterviewRepository extends PagingAndSortingRepository<PLDInterview,Long> {

  PLDInterview findById(Long id)

}
