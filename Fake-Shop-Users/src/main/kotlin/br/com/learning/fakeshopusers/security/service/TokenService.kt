package br.com.learning.fakeshopusers.security.service

import br.com.learning.fakeshopusers.entity.User
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneOffset

@Service
class TokenService {

    fun generateToken(user: User): String {
        return JWT.create()
            .withIssuer("issuer")
            .withSubject(user.username)
            .withClaim("id", user.id)
            .withExpiresAt(LocalDateTime.now().plusDays(15).toInstant(ZoneOffset.of("-03:00")))
            .sign(Algorithm.HMAC256("secretKEY"))
    }

    fun getSubject(token: String): String {
        return JWT.require(Algorithm.HMAC256("secretKEY")).withIssuer("issuer")
            .build().verify(token).subject
    }
}