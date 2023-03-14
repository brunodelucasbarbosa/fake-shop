package br.com.learning.fakeshopusers.repository

import br.com.learning.fakeshopusers.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
}