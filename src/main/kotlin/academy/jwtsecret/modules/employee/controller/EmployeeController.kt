package academy.jwtsecret.modules.employee.controller

import academy.jwtsecret.modules.employee.domain.Employee
import academy.jwtsecret.modules.employee.request.EmployeePost
import academy.jwtsecret.modules.employee.request.EmployeePut
import academy.jwtsecret.modules.employee.service.EmployeeService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/api/employee"])
@RequiredArgsConstructor
class EmployeeController (val employeeService: EmployeeService){



    @PostMapping(path = ["/save"])
    fun save(@RequestBody employeePost: EmployeePost): ResponseEntity<Employee>{
        val savedEmployee = employeeService.save(employeePost)
        return ResponseEntity(savedEmployee, HttpStatus.CREATED)
    }

    @PutMapping(path = ["/update"])
    fun update(@RequestBody employeePut: EmployeePut): ResponseEntity<Employee>{
        val updateEmployee = employeeService.update(employeePut)
        return ResponseEntity(updateEmployee, HttpStatus.OK)
    }



}