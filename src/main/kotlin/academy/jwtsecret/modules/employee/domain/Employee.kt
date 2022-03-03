package academy.jwtsecret.modules.employee.domain

import academy.jwtsecret.modules.company.domain.Company
import com.fasterxml.jackson.annotation.JsonFormat
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import java.util.Date
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
    @JsonFormat(pattern = "dd/MM/yyyy")
    var birthDate: Date? = null
    var cpf: String? = null
    var salary: Double? = null

}