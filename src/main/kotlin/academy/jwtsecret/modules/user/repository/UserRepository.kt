package academy.jwtsecret.modules.user.repository

import academy.jwtsecret.modules.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, Long> {

    fun findByEmail(email: String): User
    fun findByUsername(username: String): User
    fun findByAuthorities(authorities: String): User

}