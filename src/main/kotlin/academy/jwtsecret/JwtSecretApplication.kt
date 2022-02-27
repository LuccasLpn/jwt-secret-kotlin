package academy.jwtsecret

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
class JwtSecretApplication

fun main(args: Array<String>) {
	runApplication<JwtSecretApplication>(*args)
}