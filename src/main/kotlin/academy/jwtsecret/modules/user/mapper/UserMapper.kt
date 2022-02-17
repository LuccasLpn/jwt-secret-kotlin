package academy.jwtsecret.modules.user.mapper

import academy.jwtsecret.modules.user.domain.User
import academy.jwtsecret.modules.user.request.UserPost
import academy.jwtsecret.modules.user.request.UserPut
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper()
abstract class UserMapper {

    abstract fun toPost(userPost: UserPost): User
    abstract fun toPut(userPut: UserPut): User

    
    companion object{
        var INSTACE = Mappers.getMapperClass(UserMapper::class.java)
    }

}