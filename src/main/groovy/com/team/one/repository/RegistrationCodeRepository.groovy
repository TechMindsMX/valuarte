package com.team.one.repository

import com.team.one.domain.RegistrationCode
import org.springframework.data.repository.PagingAndSortingRepository

interface RegistrationCodeRepository extends PagingAndSortingRepository<RegistrationCode,Long> {

	RegistrationCode findByToken(String token)
	
}