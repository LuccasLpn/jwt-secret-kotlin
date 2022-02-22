package academy.jwtsecret.modules.company.domain

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "TB_COMPANY")
@AllArgsConstructor
@NoArgsConstructor
class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var name: String? = null
    var cnpj: String? = null


}