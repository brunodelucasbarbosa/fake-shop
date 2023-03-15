package br.com.learning.fakeshopusers.security.service

import br.com.learning.fakeshopusers.repository.UserRepository
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class TokenFilter(private val tokenService: TokenService, private val userRepository: UserRepository) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authorizationHeader = request.getHeader("Authorization")
        if (authorizationHeader != null) {
            val token = authorizationHeader.replace("Bearer ", "")
            println(token)
            val subject = this.tokenService.getSubject(token)
            println(subject)
            val user = this.userRepository.findByEmail(subject).get()
            println(user)
            val authentication = UsernamePasswordAuthenticationToken(user, null, user.authorities)
            println(authentication)
            SecurityContextHolder.getContext().authentication = authentication
        }

        filterChain.doFilter(request, response)
    }
}