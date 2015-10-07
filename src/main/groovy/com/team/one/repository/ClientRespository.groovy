package com.team.one.repository

import com.team.one.domain.Client
import org.springframework.data.repository.PagingAndSortingRepository

interface ClientRepository extends PagingAndSortingRepository<Client,Long> {

  Client findByUuid(String uuid)

}
