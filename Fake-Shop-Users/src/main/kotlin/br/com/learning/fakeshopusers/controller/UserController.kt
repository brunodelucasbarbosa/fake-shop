package br.com.learning.fakeshopusers.controller

import br.com.learning.fakeshopusers.controller.request.UserRequest
import br.com.learning.fakeshopusers.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class UserController(
    @Autowired private val userService: UserService
) {

    @PostMapping
    fun create(@RequestBody userRequest: UserRequest): ResponseEntity<Any> {
        return ResponseEntity.ok(userService.create(userRequest))
    }

    @GetMapping
    fun findById(@PathVariable("id") id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(userService.findById(id))
    }

    @DeleteMapping
    fun delete(@PathVariable("id") id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(userService.delete(id))
    }
}