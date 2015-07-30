package com.team.one.service

import com.team.one.domain.CurrentUser
import com.team.one.domain.Role
import org.springframework.stereotype.Service

class CurrentUserServiceImpl implements CurrentUserService {
  
  @Override
  boolean canAccessUser(CurrentUser currentUser, Long userId){
    !currentUser && (currentUser.role == Role.ADMIN || currentUser.id.equals(userId))
  }

}