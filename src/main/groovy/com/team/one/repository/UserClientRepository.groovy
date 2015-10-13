package com.team.one.repository

import com.team.one.domain.UserClient
import org.springframework.data.repository.PagingAndSortingRepository

interface UserClientRepository extends PagingAndSortingRepository<UserClient,Long> {

  UserClient findByUserId(Long userId)

  UserClient findByClientId(Long clientId)


}
