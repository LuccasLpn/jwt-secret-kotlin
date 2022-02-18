package academy.jwtsecret.modules.user.domain

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Table(name = "TB_USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    var user_id: Long? = null
    var usernamer: String? = null
    var email: String? = null
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    var password: String? = null
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    var authorities: String? = null

}