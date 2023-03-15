package br.com.learning.fakeshopusers.security.service

import br.com.learning.fakeshopusers.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        println(username)
        return userRepository.findByEmail(username).orElseThrow { throw UsernameNotFoundException("User not found") }
    }
}