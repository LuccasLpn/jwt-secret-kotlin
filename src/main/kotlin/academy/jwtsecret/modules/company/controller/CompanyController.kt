package academy.jwtsecret.modules.company.controller

import academy.jwtsecret.modules.company.domain.Company
import academy.jwtsecret.modules.company.request.CompanyPost
import academy.jwtsecret.modules.company.request.CompanyPut
import academy.jwtsecret.modules.company.service.CompanyService
import io.swagger.v3.oas.annotations.Operation
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(path = ["/api/company"])
@RequiredArgsConstructor
class CompanyController (val companyService: CompanyService){


    @PostMapping(path = ["/save"])
    @Operation(description = "save")
    fun save(@RequestBody @Valid
        companyPost: CompanyPost): ResponseEntity<Company>{
        val saveCompany = companyService.save(companyPost)
        return ResponseEntity(saveCompany, HttpStatus.CREATED)
    }

    @PutMapping(path = ["/update"])
    @Operation(description = "update")
    fun update(@RequestBody companyPut: CompanyPut): ResponseEntity<Company>{
        val updateCompany = companyService.update(companyPut)
        return ResponseEntity(updateCompany, HttpStatus.OK)
    }

    @DeleteMapping(path = ["/delete/{id}"])
    @Operation(description = "delete")
    fun delete(@PathVariable id:Long): ResponseEntity<Any>{
        val deleteCompany = companyService.delete(id)
        return ResponseEntity(deleteCompany, HttpStatus.NO_CONTENT)
    }

    @GetMapping(path = ["/findAllCompany"])
    @Operation(description = "findAllCompany")
    fun findAll(): ResponseEntity<MutableList<Company>>{
        val findAllCompany = companyService.findAll()
        return ResponseEntity(findAllCompany, HttpStatus.OK)
    }

    @GetMapping(path = ["/findByCnpj/{cnpj}"])
    @Operation(description = "findByCnpj")
    fun findByCnpj(@PathVariable cnpj: String): ResponseEntity<Company>{
        val findByCnpj = companyService.findByCnpj(cnpj)
        return ResponseEntity(findByCnpj, HttpStatus.OK)
    }

    @GetMapping(path = ["/findByName/{name}"])
    @Operation(description = "findByName")
    fun findByName(@PathVariable name: String): ResponseEntity<MutableList<Company>>{
        val findByName = companyService.findByName(name)
        return ResponseEntity(findByName, HttpStatus.OK)
    }

    @GetMapping(path = ["/findByNameIgnoreCase/{name}"])
    fun findByNameIgnoreCase(@PathVariable name: String): ResponseEntity<MutableList<Company>>{
        val findByNameIgnoreCase = companyService.findByNameIgnoreCase(name)
        return ResponseEntity(findByNameIgnoreCase, HttpStatus.OK)
    }

    @GetMapping(path = ["/findByNameIgnoreCaseContaining/{name}"])
    fun findByNameIgnoreCaseContaining(@PathVariable name: String): ResponseEntity<MutableList<Company>>{
        val findByNameIgnoreCaseContaining = companyService.findByNameIgnoreCaseContaining(name)
        return ResponseEntity(findByNameIgnoreCaseContaining, HttpStatus.OK)
    }

}