package academy.jwtsecret.modules.exception

import java.util.Date

data class ErrorsDetails(val time: Date, val message: String, val details: String){
}