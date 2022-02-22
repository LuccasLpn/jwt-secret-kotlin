package academy.jwtsecret.modules.company.controller

import academy.jwtsecret.modules.company.domain.Company
import academy.jwtsecret.modules.company.request.CompanyPost
import academy.jwtsecret.modules.company.service.CompanyService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/api/company"])
@RequiredArgsConstructor
class CompanyController (val companyService: CompanyService){


    fun save(@RequestBody companyPost: CompanyPost): ResponseEntity<Company>{
        val saveCompany = companyService.save(companyPost)
        return ResponseEntity(saveCompany, HttpStatus.CREATED)
    }
}