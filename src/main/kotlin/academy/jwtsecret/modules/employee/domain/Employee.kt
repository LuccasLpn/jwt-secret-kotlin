package academy.jwtsecret.modules.employee.domain

import academy.jwtsecret.modules.company.domain.Company
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import javax.persistence.*


@Entity(name = "TB_EMPLOYEE")
@AllArgsConstructor
@NoArgsConstructor
class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var name: String? = null
    var cargo: String? = null
    var setor: String? = null

}