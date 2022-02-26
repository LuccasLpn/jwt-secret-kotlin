package academy.jwtsecret.modules.employee.service

import academy.jwtsecret.modules.employee.domain.Employee
import academy.jwtsecret.modules.employee.mapper.EmployeeMapper
import academy.jwtsecret.modules.employee.repository.EmployeeRepository
import academy.jwtsecret.modules.employee.request.EmployeePost
import academy.jwtsecret.modules.employee.request.EmployeePut
import academy.jwtsecret.modules.exception.ValidationException
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class EmployeeService(val employeeRepository: EmployeeRepository) {

    fun save(employeePost: EmployeePost): Employee{
        val savedPost = EmployeeMapper.INSTACE.toPost(employeePost)
        validationDateEmployeeSaved(savedPost)
        return employeeRepository.save(savedPost)
    }

    fun update(employeePut: EmployeePut): Employee {
        val findById = employeePut.id?.let { findById(it) }
        val tosavedPut = EmployeeMapper.INSTACE.toPut(employeePut)
        tosavedPut.id = findById?.id
        validationDateEmployeeSaved(tosavedPut)
        return employeeRepository.save(tosavedPut)
    }

    fun delete(id:Long): Any{
        val findByIdEmployee = findById(id)
        employeeRepository.delete(findByIdEmployee)
        return "Delete SuccessFull Employee ID - $id"
    }

    fun findById(id: Long): Employee{
        return employeeRepository.findById(id).orElseThrow(){
            -> RuntimeException ("ID Not Found$id")
        }
    }

    fun findAll(): MutableList<Employee>{
        return employeeRepository.findAll()
    }

    fun findByName(name: String): Employee{
        return employeeRepository.findByNameIgnoreCase(name)
    }

    fun findByCargo(cargo: String): MutableList<Employee>{
        return employeeRepository.findByCargoIgnoreCase(cargo)
    }

    fun findBySetor(setor:String): MutableList<Employee>{
        return employeeRepository.findBySetorIgnoreCase(setor)
    }

    fun findBySetorContaining(setor:String): MutableList<Employee>{
        return employeeRepository.findBySetorIgnoreCaseContaining(setor)
    }

    fun validationDateEmployeeSaved(employee: Employee){
        if (employee.cargo!!.isEmpty()){
            throw ValidationException("Employee Cargo is Not Null")
        }
        if (employee.name!!.isEmpty()){
            throw ValidationException("Employee Name is Not Null")
        }
        if(employee.setor!!.isEmpty()){
            throw ValidationException("Employee Setor is Not Null")
        }
    }

}