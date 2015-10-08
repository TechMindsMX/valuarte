package com.team.one.service.impl

import com.team.one.command.UserCommand
import com.team.one.domain.*
import com.team.one.repository.UserRepository
import com.team.one.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository

    @Override
    Optional<User> getUserById(long id) {
      userRepository.findOne(id)
    }

    Optional<User> getUserByUsername(String username) {
      userRepository.findByUsername(username)
    }

    @Override
    Optional<User> getAllUsers() {
      userRepository.findAll()
    }

    @Override
    User getUserByEmail(String email) {
      userRepository.findByEmail(email)
    }

    @Override
    User create(UserCommand command) {
      User user = new User()
      user.username = command.username
      user.password = new BCryptPasswordEncoder().encode(command.password)
      user.role = Role.USER
      user.firstName = command.firstName
      user.lastName = command.lastName
      user.email = command.email
      userRepository.save(user)
    }

}
