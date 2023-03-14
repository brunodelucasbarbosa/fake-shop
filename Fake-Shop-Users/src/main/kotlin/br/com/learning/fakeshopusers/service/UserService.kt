package br.com.learning.fakeshopusers.service

import br.com.learning.fakeshopusers.controller.request.UserRequest
import br.com.learning.fakeshopusers.dto.UserDTO
import br.com.learning.fakeshopusers.entity.User
import br.com.learning.fakeshopusers.entity.toDTO
import br.com.learning.fakeshopusers.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun create(userRequest: UserRequest) {
        try {
            val user = User(
                id = null,
                full_name = userRequest.full_name,
                email = userRequest.email,
                password = userRequest.password,
                tax_id = userRequest.tax_id,
                phone = userRequest.phone,
                cep = userRequest.cep,
            )
            userRepository.save(user)
        } catch (e: Exception) {
            throw e
        }
    }

    fun findById(id: Long): UserDTO = userRepository.findById(id).orElseThrow { throw Exception("User not found") }.toDTO()

    fun delete(id: Long) {
        val user = userRepository.findById(id).orElseThrow { throw Exception("User not found") }
        if (user != null) userRepository.delete(user)

        throw Exception("User not found")
    }

}