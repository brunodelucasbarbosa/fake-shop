package br.com.learning.fakeshopusers.controller.request

data class UserRequest(
    val full_name: String,
    val email: String,
    val password: String,
    val tax_id: String,
    val phone: String,
    val cep: String,
)
