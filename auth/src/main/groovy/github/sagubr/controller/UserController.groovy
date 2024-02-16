package github.sagubr.controller

import github.sagubr.entity.User
import github.sagubr.message.Producer
import github.sagubr.service.UserService
import io.micronaut.http.*
import io.micronaut.http.annotation.*
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.micronaut.serde.annotation.Serdeable
import jakarta.inject.Inject

@Controller("/users")
@Serdeable
@Secured(SecurityRule.IS_AUTHENTICATED)
class UserController {

    @Inject
    UserService userService

    @Inject
    Producer producer

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    List<User> index() {
        userService.findAll()
    }

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    @Status(HttpStatus.CREATED)
    User save(@Body User user) {
        producer.send(user)
        userService.save(user)
    }

    @Get("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Status(HttpStatus.ACCEPTED)
    User get(Long id) {
        userService.findById(id)
    }

}
