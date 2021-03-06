package academy.jwtsecret.modules.employee.repository

import academy.jwtsecret.modules.employee.domain.Employee
import org.springframework.data.jpa.repository.JpaRepository


interface EmployeeRepository: JpaRepository<Employee, Long> {

    fun findByNameIgnoreCase(name: String): Employee
    fun findByCargoIgnoreCase(cargo: String): MutableList<Employee>
    fun findBySetorIgnoreCase(setor: String): MutableList<Employee>
    fun findBySetorIgnoreCaseContaining(setor: String): MutableList<Employee>
}