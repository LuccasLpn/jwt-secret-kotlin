package academy.jwtsecret.modules.employee.mapper

import academy.jwtsecret.modules.employee.domain.Employee
import academy.jwtsecret.modules.employee.request.EmployeePost
import academy.jwtsecret.modules.employee.request.EmployeePut
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper()
abstract class EmployeeMapper {

    abstract fun toPost(employeePost: EmployeePost): Employee
    abstract fun toPut(employeePut: EmployeePut): Employee

    companion object{
        var INSTACE = Mappers.getMapper(EmployeeMapper::class.java)
    }

}