package com.team.one.repository

import com.team.one.domain.Source
import org.springframework.data.repository.PagingAndSortingRepository

interface Repository extends PagingAndSortingRepository<Source,Long> {
}
