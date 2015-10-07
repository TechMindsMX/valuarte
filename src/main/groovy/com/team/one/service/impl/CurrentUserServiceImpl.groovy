package com.team.one.service.impl

import com.team.one.domain.CurrentUser
import com.team.one.domain.Role
import com.team.one.service.CurrentUserService
import org.springframework.stereotype.Service

class CurrentUserServiceImpl implements CurrentUserService {
  
  @Override
  boolean canAccessUser(CurrentUser currentUser, Long userId){
    !currentUser && (currentUser.role == Role.ADMIN || currentUser.id.equals(userId))
  }

}