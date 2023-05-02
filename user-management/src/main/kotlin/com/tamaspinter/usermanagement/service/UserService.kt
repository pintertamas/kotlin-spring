package com.tamaspinter.usermanagement.service

import com.tamaspinter.usermanagement.entity.User

interface UserService {
    fun findAll(): List<User>
    fun findById(id: Long): User
    fun createUser(user: User): User
    fun updateUser(id: Long, user: User): User
    fun deleteUser(id: Long)
}
