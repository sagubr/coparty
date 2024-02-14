package github.sagubr.services

import github.sagubr.entities.User
import github.sagubr.repository.UserRepository
import io.micronaut.core.annotation.NonNull
import io.micronaut.security.authentication.Authentication
import io.micronaut.security.authentication.AuthenticationFailureReason
import io.micronaut.security.authentication.AuthenticationRequest
import io.micronaut.security.authentication.AuthenticationResponse
import io.micronaut.security.authentication.provider.AuthenticationProvider
import io.micronaut.security.authentication.provider.HttpRequestAuthenticationProvider
import jakarta.annotation.Nullable
import jakarta.inject.Inject
import jakarta.inject.Singleton
import org.reactivestreams.Publisher

import io.micronaut.http.HttpRequest
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Singleton
class AuthenticationProviderUserPassword implements AuthenticationProvider {

    @Inject
    private UserRepository userRepository
    //@Inject
    //private PasswordEncoder passwordEncoder

    private final Logger LOG = LoggerFactory.getLogger(AuthenticationProviderUserPassword.class)

    @Override
    AuthenticationResponse authenticate(@Nullable Object requestContext, @NonNull AuthenticationRequest authRequest) {
        def user = userRepository.findByUsername(authRequest.identity as String)
        LOG.info(user.username)

        //passwordEncoder.encodePassword(user.password)

        authRequest.identity == user.getUsername() && authRequest.secret == user.getPassword()
                ? AuthenticationResponse.success("Bem vindo ${user.getUsername()}")
                : AuthenticationResponse.failure(AuthenticationFailureReason.CREDENTIALS_DO_NOT_MATCH)
    }

}
