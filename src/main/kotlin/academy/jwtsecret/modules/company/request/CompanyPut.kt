package academy.jwtsecret.modules.company.request

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*

class CompanyPut {

    var id: Long? = null
    var name: String? = null
    var cnpj: String? = null
    var nameEmployee: String? = null
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    var dataRegister: Date? = null
}