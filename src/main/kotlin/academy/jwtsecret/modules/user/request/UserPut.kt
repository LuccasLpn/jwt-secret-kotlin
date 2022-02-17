package academy.jwtsecret.modules.user.request

class UserPut {

    var user_id: Long? = null
    var usernamer: String? = null
    var email: String? = null
    var password: String? = null
    var authorities: String? = null
}