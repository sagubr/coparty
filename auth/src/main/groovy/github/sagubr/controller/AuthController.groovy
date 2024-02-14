package github.sagubr.controller

import github.sagubr.entities.User
import io.micronaut.context.annotation.Value
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.security.authentication.Authentication
import io.micronaut.security.token.generator.TokenGenerator
import io.micronaut.validation.Validated

import java.net.http.HttpResponse

@Controller("auth/")
@Validated
class AuthController {

    private TokenGenerator tokenGenerator

    @Value("{micronaut.securtity.token.jwt.signatures.secret.generator}")
    private String secret

    AuthController(TokenGenerator tokenGenerator) {
        this.tokenGenerator = tokenGenerator
    }

    @Post("/login")
    HttpResponse<?> login(@Body User user, Authentication authentication) {
        return HttpResponse.ok("Autenticação bem-sucedida para: " + authentication.getName());
    }
}
