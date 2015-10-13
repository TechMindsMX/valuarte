package com.team.one.repository

import com.team.one.domain.User
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.Optional

interface UserRepository extends PagingAndSortingRepository<User,Long> {

	Optional<User> findByUsername(String username)

	User findById(Long id)

  User findByEmail(String email)

}
