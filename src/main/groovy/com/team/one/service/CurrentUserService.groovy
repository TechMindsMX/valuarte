package com.team.one.service

import com.team.one.domain.CurrentUser

interface CurrentUserService {
	
	boolean canAccessUser(CurrentUser currentUser, Long userId)
}