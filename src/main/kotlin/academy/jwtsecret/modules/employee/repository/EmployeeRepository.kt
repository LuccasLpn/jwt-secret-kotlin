package academy.jwtsecret.modules.employee.repository

import academy.jwtsecret.modules.employee.domain.Employee
import org.springframework.data.jpa.repository.JpaRepository


interface EmployeeRepository: JpaRepository<Employee, Long> {

}