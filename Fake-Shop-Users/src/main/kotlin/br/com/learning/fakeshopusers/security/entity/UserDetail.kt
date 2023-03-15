package br.com.learning.fakeshopusers.security.entity

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

data class UserDetail (
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private val id: Long,
    @Column(nullable = false, unique = true) private val username: String,
    @Column(nullable = false) private val password: String,
    )
