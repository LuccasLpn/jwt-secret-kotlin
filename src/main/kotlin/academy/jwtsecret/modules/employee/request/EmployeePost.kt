package academy.jwtsecret.modules.employee.request

import com.fasterxml.jackson.annotation.JsonFormat
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import java.util.*

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class EmployeePost {

    var name: String? = null
    var cargo: String? = null
    var setor: String? = null
    @JsonFormat(pattern = "dd/MM/yyyy")
    var birthDate: Date? = null
    var cpf: String? = null
    var salary: Double? = null

}