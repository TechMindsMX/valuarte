package com.team.one.domain

import org.springframework.data.repository.PagingAndSortingRepository
import java.util.Optional

interface UserRepository extends PagingAndSortingRepository<User,Long> {

	Optional<User> findByUsername(String username)

	User findById(Long id)

  	User findByEmail(String email)

}
