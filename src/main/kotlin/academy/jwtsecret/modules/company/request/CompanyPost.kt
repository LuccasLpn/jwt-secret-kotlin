package academy.jwtsecret.modules.company.request

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor


@AllArgsConstructor
@NoArgsConstructor
class CompanyPost {

    var name: String? = null
    var cnpj: String? = null

}