package github.sagubr

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/auth")
class AuthController {

    @Get(uri = "/", produces = "text/plain")
    String index() {
        "Example Response"
    }
}