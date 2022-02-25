package academy.jwtsecret.modules.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.text.SimpleDateFormat
import java.util.Date

@ControllerAdvice
class ControllerAdviceRequestError : ResponseEntityExceptionHandler() {
    @ExceptionHandler(value = [(UserAlreadyExistsException::class)])
    fun handleUserAlreadyExists(ex: UserAlreadyExistsException,request: WebRequest): ResponseEntity<ErrorsDetails> {
        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mmm")
        val errorDetails = ErrorsDetails(sdf.format(Date()),
            "Validation Failed",
            ex.message!!
        )
        return ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST)
    }
}