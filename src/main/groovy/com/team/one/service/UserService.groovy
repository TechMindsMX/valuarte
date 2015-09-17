package com.team.one.service

import com.team.one.domain.*
import java.util.Optional


public interface UserService {

    Optional<User> getUserById(long id)

	Optional<User> getUserByUsername(String username)

    Optional<User> getAllUsers()

    User getUserByEmail(String email)

    User create(UserCommand command)

}
