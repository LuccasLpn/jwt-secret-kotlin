package academy.jwtsecret.modules.company.controller

import academy.jwtsecret.modules.company.service.CompanyService
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/api/company"])
@RequiredArgsConstructor
class CompanyController (val companyService: CompanyService){

}