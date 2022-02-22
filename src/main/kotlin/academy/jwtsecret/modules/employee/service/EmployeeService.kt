package academy.jwtsecret.modules.employee.service

import academy.jwtsecret.modules.employee.repository.EmployeeRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class EmployeeService(val employeeRepository: EmployeeRepository) {

}