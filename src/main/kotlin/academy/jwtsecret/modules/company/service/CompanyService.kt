package academy.jwtsecret.modules.company.service

import academy.jwtsecret.modules.company.domain.Company
import academy.jwtsecret.modules.company.mapper.CompanyMapper
import academy.jwtsecret.modules.company.repository.CompanyRepository
import academy.jwtsecret.modules.company.request.CompanyPost
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class CompanyService (val companyRepository: CompanyRepository){

    fun save(companyPost: CompanyPost): Company{
        val companyPostSave = CompanyMapper.INSTACE.toPost(companyPost)
        val save = companyRepository.save(companyPostSave)
        return save;
    }
}