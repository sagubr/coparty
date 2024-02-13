package github.sagubr.controller

import github.sagubr.entities.User
import github.sagubr.services.UserService
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.serde.annotation.SerdeImport
import jakarta.inject.Inject

@Controller("/users")
@SerdeImport(User.class)
class UserController {

    @Inject
    UserService userService

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    List<User> index() {
        userService.findAll()
    }

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    @Status(HttpStatus.CREATED)
    User save(@Body User user) {
        userService.save(user)
    }

    @Get("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Status(HttpStatus.ACCEPTED)
    User get(Long id) {
        userService.findById(id)
    }

}