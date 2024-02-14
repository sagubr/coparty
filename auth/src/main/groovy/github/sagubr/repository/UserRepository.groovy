package github.sagubr.repository

import github.sagubr.entities.User
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface UserRepository extends CrudRepository<User, Long> {

    abstract User findByUsername(String username)
}