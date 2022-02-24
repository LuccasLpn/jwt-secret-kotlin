package academy.jwtsecret.modules.company.domain

import academy.jwtsecret.modules.employee.domain.Employee
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor

import javax.persistence.*

@Entity(name = "TB_COMPANY")
@AllArgsConstructor
@NoArgsConstructor
class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var name: String? = null
    var cnpj: String? = null

    @ManyToOne
    @JoinColumn(name = "employee_name")
    var employee: Employee? = null


}