package academy.jwtsecret.modules.employee.service

import academy.jwtsecret.modules.employee.domain.Employee
import academy.jwtsecret.modules.employee.mapper.EmployeeMapper
import academy.jwtsecret.modules.employee.repository.EmployeeRepository
import academy.jwtsecret.modules.employee.request.EmployeePost
import academy.jwtsecret.modules.employee.request.EmployeePut
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class EmployeeService(val employeeRepository: EmployeeRepository) {

    fun save(employeePost: EmployeePost): Employee{
        val savedPost = EmployeeMapper.INSTACE.toPost(employeePost)
        return employeeRepository.save(savedPost)
    }

    fun update(employeePut: EmployeePut): Employee{
        val findById = employeePut.id?.let { findById(it) }
        val tosavedPut = EmployeeMapper.INSTACE.toPut(employeePut)
        tosavedPut.id = findById?.id
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

}