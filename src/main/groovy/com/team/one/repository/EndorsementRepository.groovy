package com.team.one.repository

import com.team.one.domain.Endorsement
import org.springframework.data.repository.PagingAndSortingRepository

interface EndorsementRepository extends PagingAndSortingRepository<Endorsement,Long> {

  Endorsement findById(Long id)

}
