package br.com.learning.fakeshopusers.controller.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Size

data class UserRequest(
    val full_name: String,
    @field:Email val email: String,
    val password: String,
    @field:Size(min = 14, max = 14) val tax_id: String,
    @field:Size(min = 11, max = 11) val phone: String,
    @field:Size(min = 8, max = 8) val cep: String,
)
