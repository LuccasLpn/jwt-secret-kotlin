package academy.jwtsecret.modules.user.controller

import academy.jwtsecret.modules.user.domain.User
import academy.jwtsecret.modules.user.request.UserPost
import academy.jwtsecret.modules.user.request.UserPut
import academy.jwtsecret.modules.user.service.UserService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequiredArgsConstructor
@RequestMapping(path = ["/api/user"])
class UserController(private val userService: UserService){

    @PostMapping(path = ["/save"])
    fun saveUser(@RequestBody userPost: UserPost): ResponseEntity<User>{
        val savedUser = userService.save(userPost)
        return ResponseEntity(savedUser, HttpStatus.CREATED)
    }

    @GetMapping(path = ["/findById/{id}"])
    fun findById(@PathVariable id:Long): ResponseEntity<User>{
        val findById = userService.findById(id)
        return ResponseEntity(findById, HttpStatus.OK)
    }

    @GetMapping(path = ["/findByEmail/{email}"])
    fun findByEmail(@PathVariable email:String): ResponseEntity<MutableList<User>>{
        val findByEmail = userService.findByEmailIgnoreCase(email)
        return ResponseEntity(findByEmail, HttpStatus.OK)
    }

    @PutMapping(path = ["/update"])
    fun update(@RequestBody userPut: UserPut): ResponseEntity<User>{
        val update = userService.update(userPut)
        return ResponseEntity(update, HttpStatus.NO_CONTENT)
    }

    @DeleteMapping(path = ["/delete/{id}"])
    fun delete(@PathVariable id:Long): ResponseEntity<Any>{
        val userIdDelete = userService.delete(id)
        return ResponseEntity(userIdDelete,HttpStatus.OK)
    }

    @GetMapping(path = ["/findAllUser"])
    fun findAll(): ResponseEntity<MutableList<User>>{
        val findAllUser = userService.findAll()
        return ResponseEntity(findAllUser, HttpStatus.OK)
    }

    @DeleteMapping(path = ["/deleteAllUser"])
    fun deleteAllUser(): ResponseEntity<Any>{
        val deleteAll = userService.deleteAll()
        return ResponseEntity(deleteAll,HttpStatus.OK)
    }

    @GetMapping(path = ["/findByUsername/{username}"])
    fun findByUsername(@PathVariable username:String): ResponseEntity<User>{
        val findByUsername = userService.findByUsername(username)
        return ResponseEntity(findByUsername, HttpStatus.OK)
    }

    @GetMapping(path = ["/findByAuthorities/{authorities}"])
    fun findByAuthorities(@PathVariable authorities:String): ResponseEntity<User>{
        val findByAuthorities = userService.findByAuthorities(authorities)
        return ResponseEntity(findByAuthorities, HttpStatus.OK)
    }

}