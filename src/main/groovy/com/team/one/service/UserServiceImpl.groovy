package com.team.one.service

import com.team.one.domain.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.util.Optional
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
