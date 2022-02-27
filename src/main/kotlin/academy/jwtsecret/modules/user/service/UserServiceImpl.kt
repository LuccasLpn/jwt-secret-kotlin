package academy.jwtsecret.modules.user.service

import academy.jwtsecret.modules.user.domain.UserSS
import academy.jwtsecret.modules.user.repository.UserRepository
import lombok.RequiredArgsConstructor
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class UserServiceImpl(var userRepository: UserRepository):UserDetailsService{

    override fun loadUserByUsername(email: String?): UserDetails {
        val user = email?.let { userRepository.findByEmail(it) } ?: throw UsernameNotFoundException(email)
        return UserSS(user)
    }

}