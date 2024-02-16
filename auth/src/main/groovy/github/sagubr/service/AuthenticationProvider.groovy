package github.sagubr.service

import github.sagubr.entity.User
import github.sagubr.repository.UserRepository
import io.micronaut.core.annotation.NonNull
import io.micronaut.security.authentication.*
import jakarta.annotation.Nullable
import jakarta.inject.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Singleton
class AuthenticationProvider implements io.micronaut.security.authentication.provider.AuthenticationProvider {

    @Inject
    private UserRepository userRepository
    //@Inject
    //private PasswordEncoder passwordEncoder

    private final Logger LOG = LoggerFactory.getLogger(AuthenticationProvider.class)

    @Override
    AuthenticationResponse authenticate(@Nullable Object requestContext, @NonNull AuthenticationRequest authRequest) {
        User user = userRepository.findByUsername(authRequest.identity as String)
        LOG.info(user.username)

        //passwordEncoder.encodePassword(user.password)

        authRequest.identity == user.getUsername() && authRequest.secret == user.getPassword()
                ? AuthenticationResponse.success("${user.getUsername()}")
                : AuthenticationResponse.failure(AuthenticationFailureReason.CREDENTIALS_DO_NOT_MATCH)
    }

}
