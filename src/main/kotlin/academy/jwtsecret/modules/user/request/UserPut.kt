package academy.jwtsecret.modules.user.request

class UserPut {

    var id: Long? = null
    var username: String? = null
    var email: String? = null
    var password: String? = null

    var authorities: String? = null

}