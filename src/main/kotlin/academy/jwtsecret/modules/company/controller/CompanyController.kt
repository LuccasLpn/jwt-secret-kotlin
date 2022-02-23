package academy.jwtsecret.modules.company.controller

import academy.jwtsecret.modules.company.domain.Company
import academy.jwtsecret.modules.company.request.CompanyPost
import academy.jwtsecret.modules.company.request.CompanyPut
import academy.jwtsecret.modules.company.service.CompanyService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/api/company"])
@RequiredArgsConstructor
class CompanyController (val companyService: CompanyService){


    @PostMapping(path = ["/save"])
    fun save(@RequestBody companyPost: CompanyPost): ResponseEntity<Company>{
        val saveCompany = companyService.save(companyPost)
        return ResponseEntity(saveCompany, HttpStatus.CREATED)
    }

    @PutMapping(path = ["/update"])
    fun update(@RequestBody companyPut: CompanyPut): ResponseEntity<Company>{
        val updateCompany = companyService.update(companyPut)
        return ResponseEntity(updateCompany, HttpStatus.OK)
    }

    @DeleteMapping(path = ["/delete/{id}"])
    fun delete(@PathVariable id:Long): ResponseEntity<Any>{
        val deleteCompany = companyService.delete(id)
        return ResponseEntity(deleteCompany, HttpStatus.NO_CONTENT)
    }

    @GetMapping(path = ["/findAllCompany"])
    fun findAll(): ResponseEntity<MutableList<Company>>{
        val findAllCompany = companyService.findAll()
        return ResponseEntity(findAllCompany, HttpStatus.OK)
    }

}