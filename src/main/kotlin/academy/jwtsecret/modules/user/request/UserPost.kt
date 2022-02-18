package academy.jwtsecret.modules.user.request

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class UserPost {

    var usernamer: String? = null
    var email: String? = null
    var password: String? = null
    var authorities: String? = null
}