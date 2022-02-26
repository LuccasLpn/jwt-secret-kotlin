package academy.jwtsecret.modules.company.repository

import academy.jwtsecret.modules.company.domain.Company
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyRepository: JpaRepository<Company, Long>{

}