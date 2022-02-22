package academy.jwtsecret.modules.employee.controller

import academy.jwtsecret.modules.employee.domain.Employee
import academy.jwtsecret.modules.employee.request.EmployeePost
import academy.jwtsecret.modules.employee.request.EmployeePut
import academy.jwtsecret.modules.employee.service.EmployeeService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
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

    @DeleteMapping(path = ["/delete/{id}"])
    fun delete(@PathVariable id: Long): ResponseEntity<Any>{
        val deleteEmployee = employeeService.delete(id)
        return ResponseEntity(deleteEmployee, HttpStatus.OK)
    }

    @GetMapping(path = ["/findAllEmployee"])
    fun findAll(): ResponseEntity<MutableList<Employee>>{
        val findAllEmployee = employeeService.findAll()
        return ResponseEntity(findAllEmployee,HttpStatus.OK)
    }

    @GetMapping(path = ["/findById/{id}"])
    fun findById(@PathVariable id:Long): ResponseEntity<Employee>{
        val findByIdEmployee = employeeService.findById(id)
        return ResponseEntity(findByIdEmployee,HttpStatus.OK)
    }

    @GetMapping(path = ["/findByName/{name}"])
    fun findByName(@PathVariable name:String): ResponseEntity<Employee>{
        val findByNameEmployee = employeeService.findByName(name)
        return ResponseEntity(findByNameEmployee, HttpStatus.OK)
    }

    @GetMapping(path = ["/findByCargo/{cargo}"])
    fun findByCargo(@PathVariable cargo:String): ResponseEntity<MutableList<Employee>>{
        val findByCargo = employeeService.findByCargo(cargo)
        return ResponseEntity(findByCargo, HttpStatus.OK)
    }

    @GetMapping(path = ["/findBySetor/{setor}"])
    fun findBySetor(@PathVariable setor: String): ResponseEntity<MutableList<Employee>>{
        val findBySetor = employeeService.findBySetor(setor)
        return ResponseEntity(findBySetor, HttpStatus.OK)
    }



}