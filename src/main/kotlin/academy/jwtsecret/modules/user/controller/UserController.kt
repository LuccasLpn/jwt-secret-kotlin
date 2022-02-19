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
        val savedUserPost = userService.insert(userPost)
        return ResponseEntity(savedUserPost, HttpStatus.CREATED)
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

}