package academy.jwtsecret.modules.company.service

import academy.jwtsecret.modules.company.domain.Company
import academy.jwtsecret.modules.company.mapper.CompanyMapper
import academy.jwtsecret.modules.company.repository.CompanyRepository
import academy.jwtsecret.modules.company.request.CompanyPost
import academy.jwtsecret.modules.company.request.CompanyPut
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

    fun update(companyPut: CompanyPut): Company{
        val findById = companyPut.id?.let { findById(it) }
        val toSavedPut = CompanyMapper.INSTACE.toPut(companyPut)
        toSavedPut.id = findById?.id
        val savedPut = companyRepository.save(toSavedPut)
        return savedPut
    }



    fun findById(id:Long): Company{
        return companyRepository.findById(id).orElseThrow {
            -> RuntimeException ("ID Not Found$id")
        }
    }



}