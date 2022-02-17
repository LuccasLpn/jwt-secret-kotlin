package academy.jwtsecret.modules.user.service

import academy.jwtsecret.modules.user.repository.UserRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class UserService(private val userRepository: UserRepository){

}