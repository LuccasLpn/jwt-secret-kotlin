package academy.jwtsecret.modules.user.domain

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import java.util.stream.Collectors

class UserSS(private val user: User):UserDetails{

    override fun getAuthorities(): Collection<GrantedAuthority?> {
        return Arrays.stream(user.authorities!!.split(",").toTypedArray())
            .map { role: String? ->
                SimpleGrantedAuthority(role) }.collect(Collectors.toList())
    }

    override fun getPassword() = user.password
    override fun getUsername() = user.email
    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired() = true
    override fun isEnabled() = true
}