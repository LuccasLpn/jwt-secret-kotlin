package academy.jwtsecret.modules.user.security


import academy.jwtsecret.authorization
import academy.jwtsecret.bearer
import academy.jwtsecret.modules.user.domain.Credentials
import academy.jwtsecret.modules.user.domain.User
import academy.jwtsecret.modules.user.domain.UserSS
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTAuthenticationFilter(authenticationManager: AuthenticationManager, private var jwtUtil: JWTUtil) :
    UsernamePasswordAuthenticationFilter() {

    init {
        this.authenticationManager = authenticationManager
    }

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse?): Authentication? {
        try {
            val (email, password) = ObjectMapper().readValue(request.inputStream, Credentials::class.java)
            val token = UsernamePasswordAuthenticationToken(email, password)
            return authenticationManager.authenticate(token)
        } catch (e: Exception) {
            throw UsernameNotFoundException("User not found!")
        }
    }

    override fun successfulAuthentication(request: HttpServletRequest?,
                                          response: HttpServletResponse,
                                          chain: FilterChain?, authResult:
                                          Authentication) {

        val username = (authResult.principal as UserSS).username
        val token = username?.let { jwtUtil.generateToken(it) }
        response.addHeader(authorization, "$bearer $token")
    }

}