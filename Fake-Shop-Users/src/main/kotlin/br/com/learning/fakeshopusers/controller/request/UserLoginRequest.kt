package br.com.learning.fakeshopusers.controller.request

import jakarta.validation.constraints.Email

data class UserLoginRequest(
    @field:Email val email: String,
    val password: String
)
