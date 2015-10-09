package com.team.one.repository

import com.team.one.domain.References
import org.springframework.data.repository.PagingAndSortingRepository

interface ReferencesRepository extends PagingAndSortingRepository<References,Long> {

  References findById(Long id)

}
