package br.com.learning.fakeshopusers.service

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class PasswordEncoderServiceImpl {

    private val BCRYPT_ROUNDS = 10

    fun encode(password: String): String {
        return BCryptPasswordEncoder(BCRYPT_ROUNDS).encode(password)
    }

    fun matches(password: String, encodedPassword: String): Boolean {
        return BCryptPasswordEncoder(BCRYPT_ROUNDS).matches(password, encodedPassword)
    }
}