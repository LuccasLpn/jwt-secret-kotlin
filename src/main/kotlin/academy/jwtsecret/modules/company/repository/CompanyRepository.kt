package academy.jwtsecret.modules.company.repository

import academy.jwtsecret.modules.company.domain.Company
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyRepository: JpaRepository<Company, Long>{

    fun findByCnpj(cnpj: String): Company
    fun findByName(name: String): MutableList<Company>
    fun findByNameIgnoreCase(name: String): MutableList<Company>
}