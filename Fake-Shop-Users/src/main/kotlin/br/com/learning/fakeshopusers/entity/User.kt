package br.com.learning.fakeshopusers.entity

import br.com.learning.fakeshopusers.dto.UserDTO
import jakarta.persistence.*

@Table(name = "users")
@Entity
data class User(
    @Id @Column @GeneratedValue(strategy = GenerationType.AUTO) val id: Long?,
    @Column(nullable = false) val full_name: String,
    @Column(nullable = false) val email: String,
    @Column(nullable = false) private val password: String,
    @Column(nullable = false) val tax_id: String,
    @Column(nullable = false) val phone: String,
    @Column(nullable = false) val cep: String,
)

fun User.toDTO() = UserDTO(
    id = this.id,
    full_name = this.full_name,
    email = this.email,
    tax_id = this.tax_id,
    phone = this.phone,
    cep = this.cep,
)