package academy.jwtsecret.modules.user.request

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class UserPost{

    var username: String? = null
    @Email
    var email: String? = null
    @NotNull
    var password: String? = null
    var authorities: String? = null

}