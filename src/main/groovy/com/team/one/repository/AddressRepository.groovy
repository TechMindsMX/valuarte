package com.team.one.repository

import com.team.one.domain.*
import org.springframework.data.repository.PagingAndSortingRepository

interface AddressRepository extends PagingAndSortingRepository<Address,Long> {

	Address findById(Long id)

}
