package academy.jwtsecret.modules.company.service

import academy.jwtsecret.modules.company.repository.CompanyRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class CompanyService (val companyRepository: CompanyRepository){
}