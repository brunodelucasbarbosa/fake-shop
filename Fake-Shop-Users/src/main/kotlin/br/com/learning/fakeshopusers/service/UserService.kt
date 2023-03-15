package br.com.learning.fakeshopusers.service

import br.com.learning.fakeshopusers.controller.request.UserRequest
import br.com.learning.fakeshopusers.dto.UserDTO
import br.com.learning.fakeshopusers.entity.User
import br.com.learning.fakeshopusers.entity.toDTO
import br.com.learning.fakeshopusers.exception.ResourceNotFoundException
import br.com.learning.fakeshopusers.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoderService: PasswordEncoderServiceImpl
) {

    fun create(userRequest: UserRequest): UserDTO {
        try {
            val existsEmail = userRepository.findByEmail(userRequest.email)
            if (existsEmail.isPresent) throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists")

            val user = User(
                id = null,
                full_name = userRequest.full_name,
                email = userRequest.email,
                password = passwordEncoderService.encode(userRequest.password),
                tax_id = userRequest.tax_id,
                phone = userRequest.phone,
                cep = userRequest.cep,
            )
            userRepository.save(user)

            return user.toDTO()
        } catch (e: Exception) {
            throw ResourceNotFoundException("Failed to create user")
        }
    }

    fun findById(id: Long): UserDTO = userRepository.findById(id).orElseThrow { throw ResourceNotFoundException("User not found") }
        .toDTO()

    fun delete(id: Long) {
        val user = userRepository.findById(id).orElseThrow { throw ResourceNotFoundException("User not found") }
        if (user != null) userRepository.delete(user)

        throw Exception("User not found")
    }

}