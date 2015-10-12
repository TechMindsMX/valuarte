package com.team.one.repository

import com.team.one.domain.Client
import org.springframework.data.repository.CrudRepository

interface ClientRepository extends CrudRepository<Client,Long> {

}
