package com.team.one.service

import com.team.one.domain.Client
import com.team.one.domain.User

interface AdminCreditService {

  Client create(Map domainList,String userCreate,User user)

}
