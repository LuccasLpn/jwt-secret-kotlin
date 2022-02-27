package academy.jwtsecret.modules.company.service

import academy.jwtsecret.modules.company.domain.Company
import academy.jwtsecret.modules.company.mapper.CompanyMapper
import academy.jwtsecret.modules.company.repository.CompanyRepository
import academy.jwtsecret.modules.company.request.CompanyPost
import academy.jwtsecret.modules.company.request.CompanyPut
import academy.jwtsecret.modules.employee.repository.EmployeeRepository
import academy.jwtsecret.modules.exception.ValidationException
import lombok.RequiredArgsConstructor
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class CompanyService (val companyRepository: CompanyRepository,
                      val employeeRepository: EmployeeRepository){

    fun save(companyPost: CompanyPost): Company {
        val employeeName = companyPost.nameEmployee?.let { employeeRepository.findByNameIgnoreCase(it) }
        val companyPostSave = CompanyMapper.INSTACE.toPost(companyPost)
        companyPostSave.employee = employeeName
        validationDateCompanySave(companyPostSave)
        return companyRepository.save(companyPostSave)
    }

    fun update(companyPut: CompanyPut): Company{
        val employeeName = companyPut.nameEmployee?.let { employeeRepository.findByNameIgnoreCase(it) }
        val findById = companyPut.id?.let { findById(it) }
        val toSavedPut = CompanyMapper.INSTACE.toPut(companyPut)
        toSavedPut.id = findById?.id
        toSavedPut.employee = employeeName
        return companyRepository.save(toSavedPut)
    }

    fun delete(id:Long): Any{
        val findById = findById(id)
        companyRepository.delete(findById)
        return "Delete SuccessFull Company ID $id"
    }


    fun findAll(): MutableList<Company>{
        return companyRepository.findAll(Sort.by(Sort.Direction.ASC, "employee_name"))
    }

    fun findById(id:Long): Company{
        return companyRepository.findById(id).orElseThrow {
            -> ValidationException ("ID Not Found $id")
        }
    }

    fun findByName(name: String): MutableList<Company>{
        return companyRepository.findByName(name)
    }

    fun findByCnpj(cnpj: String): Company{
        return companyRepository.findByCnpj(cnpj)
    }

    fun validationDateCompanySave(company: Company) {
        if (company.name!!.isEmpty()) {
            throw ValidationException("Company Name is Not Null")
        }
        if (company.cnpj!!.isEmpty()) {
            throw ValidationException("Company Cnpj is Not Null")
        }
    }
}