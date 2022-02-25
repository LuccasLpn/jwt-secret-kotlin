package academy.jwtsecret.modules.exception

class UserAlreadyExistsException(override val message: String?) : Exception(message)