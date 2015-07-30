package com.team.one.service

import com.team.one.domain.User
import com.team.one.domain.CurrentUser
import com.team.one.service.UserService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service

@Service
class CurrentUserDetailService implements UserDetailsService {
  
  @Autowired
  UserService userService

  @Override
  CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userService.getUserByUsername(username).orElseThrow{ ->
      new UsernameNotFoundException(String.format("User with username : ${username} was not found"))
    }
    new CurrentUser(user)
  }

}
