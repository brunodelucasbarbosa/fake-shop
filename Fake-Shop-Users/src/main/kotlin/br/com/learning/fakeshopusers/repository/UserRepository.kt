package br.com.learning.fakeshopusers.repository

import br.com.learning.fakeshopusers.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findByEmail(username: String): Optional<User>
}