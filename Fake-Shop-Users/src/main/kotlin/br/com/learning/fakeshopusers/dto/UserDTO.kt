package br.com.learning.fakeshopusers.dto

data class UserDTO(
    val id: Long?,
    val full_name: String,
    val email: String,
    val tax_id: String,
    val phone: String,
    val cep: String,
)
