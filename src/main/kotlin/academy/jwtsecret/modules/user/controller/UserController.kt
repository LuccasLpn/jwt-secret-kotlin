package academy.jwtsecret.modules.user.controller

import academy.jwtsecret.modules.user.service.UserService
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class UserController(private val userService: UserService){

}