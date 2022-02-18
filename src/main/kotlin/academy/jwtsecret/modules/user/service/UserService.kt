package academy.jwtsecret.modules.user.service

import academy.jwtsecret.modules.user.domain.User
import academy.jwtsecret.modules.user.mapper.UserMapper
import academy.jwtsecret.modules.user.repository.UserRepository
import academy.jwtsecret.modules.user.request.UserPost
import academy.jwtsecret.modules.user.request.UserPut
import lombok.RequiredArgsConstructor
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class UserService(val userRepository: UserRepository){

    fun insert(userPost: UserPost): User{
        userPost.password = bCryptPasswordEncoder().encode(userPost.password)
        val saveUser = UserMapper.INSTACE.toPost(userPost)
        return userRepository.save(saveUser)
    }

    fun findById(id:Long):User{
        return userRepository.findById(id).orElseThrow(){
            RuntimeException("ID NOT FOUND" + id)
        }
    }

    fun update(userPut: UserPut): User{
        userPut.user_id?.let { findById(it) }
        val user = UserMapper.INSTACE.toPut(userPut)
        user.user_id = userPut.user_id
        return userRepository.save(user)
    }

}

@Bean
fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
    return BCryptPasswordEncoder()
}
