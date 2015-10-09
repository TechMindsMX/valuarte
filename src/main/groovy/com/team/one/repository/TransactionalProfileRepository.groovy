package com.team.one.repository

import com.team.one.domain.TransactionalProfile
import org.springframework.data.repository.PagingAndSortingRepository

interface TransactionalProfileRepository extends PagingAndSortingRepository<TransactionalProfile,Long> {

  TransactionalProfile findById(Long id)

}
