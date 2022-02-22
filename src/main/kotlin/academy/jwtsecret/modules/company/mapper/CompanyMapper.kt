package academy.jwtsecret.modules.company.mapper

import academy.jwtsecret.modules.company.domain.Company
import academy.jwtsecret.modules.company.request.CompanyPost
import academy.jwtsecret.modules.company.request.CompanyPut
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
abstract class CompanyMapper {

    abstract fun toPost(companyPost: CompanyPost): Company
    abstract fun toPut(companyPut: CompanyPut): Company

    companion object{
        var INSTACE = Mappers.getMapper(CompanyMapper::class.java)
    }
}