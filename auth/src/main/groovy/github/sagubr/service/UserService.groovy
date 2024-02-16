package github.sagubr.service

import github.sagubr.entity.User
import github.sagubr.message.Producer
import github.sagubr.repository.UserRepository
import io.micronaut.core.annotation.NonNull
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class UserService {

    @Inject
    UserRepository userRepository

    List<User> findAll(){
        userRepository.findAll()
    }

    User save(@NonNull User user){
        userRepository.save(user)
    }

    User findById(@NonNull Long id){
        userRepository.findById(id).get()
    }

}
