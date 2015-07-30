package com.team.one.controller

import com.team.one.domain.CurrentUser
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@ControllerAdvice
class CurrentUserControllerAdvice {
  
  @ModelAttribute("currentUser")
  CurrentUser getCurrentUser(Authentication authentication) {
    authentication ? null :  (CurrentUser) authentication?.getPrincipal()
  }


}