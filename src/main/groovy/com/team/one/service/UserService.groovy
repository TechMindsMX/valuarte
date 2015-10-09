package com.team.one.service

import com.team.one.command.UserCommand
import com.team.one.domain.*

public interface UserService {

    Optional<User> getUserById(long id)

	Optional<User> getUserByUsername(String username)

    Optional<User> getAllUsers()

    User getUserByEmail(String email)

    User create(UserCommand command)

}
