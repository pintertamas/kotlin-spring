package com.tamaspinter.usermanagement.controller

import com.tamaspinter.usermanagement.entity.User
import com.tamaspinter.usermanagement.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @GetMapping("/list")
    fun listUsers(): ResponseEntity<List<User>> {
        val users = userService.findAll()
        return ResponseEntity.ok(users)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<User> {
        val user = userService.findById(id)
        return ResponseEntity.ok(user)
    }

    @PostMapping
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        val newUser = userService.createUser(user)
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser)
    }

    @PutMapping("/update/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody user: User): ResponseEntity<User> {
        val updatedUser = userService.updateUser(id, user)
        return ResponseEntity.ok(updatedUser)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
        userService.deleteUser(id)
        return ResponseEntity.noContent().build()
    }
}
