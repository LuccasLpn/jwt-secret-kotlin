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
import org.springframework.transaction.annotation.Transactional

@Service
@RequiredArgsConstructor
class UserService(val userRepository: UserRepository){

    @Transactional
    fun save(userPost: UserPost): User {
        userPost.password = bCryptPasswordEncoder().encode(userPost.password)
        val savedUser = UserMapper.INSTACE.toPost(userPost)
       /* savedUser.authorities = "ROLE_USER"*/
        return userRepository.save(savedUser)
    }

    fun findById(id:Long): User {
        return userRepository.findById(id).orElseThrow() {
            RuntimeException("ID NOT FOUND $id")
        }
    }

    fun update(userPut: UserPut): User {
        userPut.password = bCryptPasswordEncoder().encode(userPut.password)
        userPut.id?.let { findById(it) }
        val user = UserMapper.INSTACE.toPut(userPut)
        user.id = userPut.id
        return userRepository.save(user)
    }

    fun delete(id:Long): Any {
        val userIdDelete = findById(id)
        userRepository.delete(userIdDelete)
        return "Delete SuccessFull"
    }

    fun findAll(): MutableList<User> {
        return userRepository.findAll()
    }

    fun deleteAll(): Any {
        userRepository.deleteAll()
        return "Delete SuccessFull"
    }

    fun findByUsername(username:String): User {
        return userRepository.findByUsername(username)
    }

    fun findByAuthorities(authorities:String): User {
        return userRepository.findByAuthorities(authorities)
    }

}

@Bean
fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
    return BCryptPasswordEncoder()
}

