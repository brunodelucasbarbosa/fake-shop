package br.com.learning.fakeshopusers.entity

import br.com.learning.fakeshopusers.dto.UserDTO
import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.Collections

@Table(name = "users")
@Entity
data class User (
    @Id @Column @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long?,
    @Column(nullable = false) val full_name: String,
    @Column(nullable = false) val email: String,
    @Column(nullable = false) private val password: String,
    @Column(nullable = false) val tax_id: String,
    @Column(nullable = false) val phone: String,
    @Column(nullable = false) val cep: String,
): UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = Collections.singletonList(SimpleGrantedAuthority("USER"))
    override fun getPassword(): String = this.password
    override fun getUsername(): String = this.email
    override fun isAccountNonExpired(): Boolean = true;
    override fun isAccountNonLocked(): Boolean = true;
    override fun isCredentialsNonExpired(): Boolean = true;
    override fun isEnabled(): Boolean = true
}

fun User.toDTO() = UserDTO(
    id = this.id,
    full_name = this.full_name,
    email = this.email,
    tax_id = this.tax_id,
    phone = this.phone,
    cep = this.cep,
)