package academy.jwtsecret.modules.company.domain

import academy.jwtsecret.modules.employee.domain.Employee
import com.fasterxml.jackson.annotation.JsonFormat
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import java.util.Date

import javax.persistence.*

@Entity(name = "TB_COMPANY")
@AllArgsConstructor
@NoArgsConstructor
class Company {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Long? = null
    @Column(name = "NAME")
    var name: String? = null
    @Column(name = "CNPJ")
    var cnpj: String? = null
    @Column(name = "DATA")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    var dataRegister: Date? = null
    @ManyToOne(cascade = [( CascadeType.ALL)])
    @JoinColumn(name = "employee_name", referencedColumnName = "name")
    var employee: Employee? = null



}