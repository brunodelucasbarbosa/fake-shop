package br.com.learning.fakeshopusers.controller

import br.com.learning.fakeshopusers.controller.request.UserLoginRequest
import br.com.learning.fakeshopusers.controller.request.UserRequest
import br.com.learning.fakeshopusers.dto.UserDTO
import br.com.learning.fakeshopusers.entity.User
import br.com.learning.fakeshopusers.kafka.KafkaProducer
import br.com.learning.fakeshopusers.security.service.TokenService
import br.com.learning.fakeshopusers.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/user")
@Validated
class UserController(
    private val userService: UserService,
    private val authenticationManager: AuthenticationManager,
    private val tokenService: TokenService,
    private val kafkaProducer: KafkaProducer
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody userRequest: UserRequest): UserDTO {
        return userService.create(userRequest)
    }

    @PostMapping("/login")
    fun login(@RequestBody userLoginRequest: UserLoginRequest): String {
        val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(
            userLoginRequest.email,
            userLoginRequest.password)
        val authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken)

        val user = authenticate.principal as User
        kafkaProducer.sendMessage("User ${user.full_name} logged in")
        return tokenService.generateToken(user)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): UserDTO {
        return userService.findById(id)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(userService.delete(id))
    }
}