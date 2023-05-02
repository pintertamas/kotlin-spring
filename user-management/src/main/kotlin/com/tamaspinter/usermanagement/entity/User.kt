package com.tamaspinter.usermanagement.entity

import jakarta.persistence.*
import jakarta.persistence.Table

@Entity
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column(nullable = false, unique = true)
        val username: String = "",

        @Column(nullable = false)
        val password: String = "",

        @Column(nullable = false)
        val email: String = "",

        @Column(nullable = false)
        val enabled: Boolean = false,
)