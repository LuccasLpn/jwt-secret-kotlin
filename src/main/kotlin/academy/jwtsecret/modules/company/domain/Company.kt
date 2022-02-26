package academy.jwtsecret.modules.company.domain

import academy.jwtsecret.modules.employee.domain.Employee
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor

import javax.persistence.*

@Entity(name = "TB_COMPANY")
@AllArgsConstructor
@NoArgsConstructor
class Company {

    @Column(name = "ID")@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column(name = "NAME")
    var name: String? = null
    @Column(name = "CNPJ")
    var cnpj: String? = null
    @ManyToOne(cascade = [( CascadeType.ALL)])
    @JoinColumn(name = "employee_name", referencedColumnName = "name")
    var employee: Employee? = null



}