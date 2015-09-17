package com.team.one.domain
import org.springframework.data.repository.PagingAndSortingRepository

interface RegistrationCodeRepository extends PagingAndSortingRepository<RegistrationCode,Long> {

	RegistrationCode findByToken(String token)
	
}