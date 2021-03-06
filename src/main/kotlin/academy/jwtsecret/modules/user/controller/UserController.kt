package academy.jwtsecret.modules.user.controller

import academy.jwtsecret.modules.user.domain.User
import academy.jwtsecret.modules.user.request.UserPost
import academy.jwtsecret.modules.user.request.UserPut
import academy.jwtsecret.modules.user.service.UserService
import io.swagger.v3.oas.annotations.Operation
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequiredArgsConstructor
@RequestMapping(path = ["/api/user"])
class UserController(private val userService: UserService){

    @PostMapping(path = ["/save"])
    @Operation(description = "Save User")
    fun saveUser(@RequestBody userPost: UserPost): ResponseEntity<User>{
        val savedUser = userService.save(userPost)
        return ResponseEntity(savedUser, HttpStatus.CREATED)
    }

    @GetMapping(path = ["/findById/{id}"])
    @Operation(description = "FindById")
    fun findById(@PathVariable id:Long): ResponseEntity<User>{
        val findById = userService.findById(id)
        return ResponseEntity(findById, HttpStatus.OK)
    }

    @PutMapping(path = ["/update"])
    @Operation(description = "Update")
    fun update(@RequestBody userPut: UserPut): ResponseEntity<User>{
        val update = userService.update(userPut)
        return ResponseEntity(update, HttpStatus.NO_CONTENT)
    }

    @DeleteMapping(path = ["/delete/{id}"])
    @Operation(description = "Delete")
    fun delete(@PathVariable id:Long): ResponseEntity<Any>{
        val userIdDelete = userService.delete(id)
        return ResponseEntity(userIdDelete,HttpStatus.OK)
    }

    @GetMapping(path = ["/findAllUser"])
    @Operation(description = "findAllUser")
    fun findAll(): ResponseEntity<MutableList<User>>{
        val findAllUser = userService.findAll()
        return ResponseEntity(findAllUser, HttpStatus.OK)
    }

    @DeleteMapping(path = ["/deleteAllUser"])
    @Operation(description = "deleteAllUser")
    fun deleteAllUser(): ResponseEntity<Any>{
        val deleteAll = userService.deleteAll()
        return ResponseEntity(deleteAll,HttpStatus.OK)
    }

    @GetMapping(path = ["/findByUsername/{username}"])
    @Operation(description = "findByUsername")
    fun findByUsername(@PathVariable username:String): ResponseEntity<User>{
        val findByUsername = userService.findByUsername(username)
        return ResponseEntity(findByUsername, HttpStatus.OK)
    }

    @GetMapping(path = ["/findByAuthorities/{authorities}"])
    @Operation(description = "findByAuthorities")
    fun findByAuthorities(@PathVariable authorities:String): ResponseEntity<User>{
        val findByAuthorities = userService.findByAuthorities(authorities)
        return ResponseEntity(findByAuthorities, HttpStatus.OK)
    }

}