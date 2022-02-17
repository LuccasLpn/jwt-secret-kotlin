package academy.jwtsecret.modules.user.domain

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "TB_USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var user_id: Long? = null
    var usernamer: String? = null
    var email: String? = null
    var password: String? = null
    var authorities: String? = null

}