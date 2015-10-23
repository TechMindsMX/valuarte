package com.team.one.repository

import com.team.one.domain.*
import org.springframework.data.repository.PagingAndSortingRepository

interface OwnerIdentificationRepository extends PagingAndSortingRepository<OwnerIdentification,Long> {

  OwnerIdentification findById(Long id)

}
