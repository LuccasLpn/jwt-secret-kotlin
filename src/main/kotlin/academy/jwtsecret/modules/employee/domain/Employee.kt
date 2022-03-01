package academy.jwtsecret.modules.employee.domain

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


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