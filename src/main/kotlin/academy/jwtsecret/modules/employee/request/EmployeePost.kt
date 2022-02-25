package academy.jwtsecret.modules.employee.request

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class EmployeePost {

    var name: String? = null
    var cargo: String? = null
    var setor: String? = null

}