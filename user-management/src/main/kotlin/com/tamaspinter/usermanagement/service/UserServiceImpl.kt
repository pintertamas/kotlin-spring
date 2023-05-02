package com.tamaspinter.usermanagement.service

import com.tamaspinter.usermanagement.entity.User
import com.tamaspinter.usermanagement.repository.UserRepository
import org.springframework.stereotype.Service
import jakarta.persistence.EntityNotFoundException

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {

    override fun findAll(): List<User> {
        return userRepository.findAll()
    }

    override fun findById(id: Long): User {
        return userRepository.findById(id).orElseThrow { EntityNotFoundException("User not found with ID: $id") }
    }

    override fun createUser(user: User): User {
        return userRepository.save(user)
    }

    override fun updateUser(id: Long, user: User): User {
        val existingUser = findById(id)
        val updatedUser = existingUser.copy(
            username = user.username,
            password = user.password,
            email = user.email,
            enabled = user.enabled
        )
        return userRepository.save(updatedUser)
    }

    override fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }
}
