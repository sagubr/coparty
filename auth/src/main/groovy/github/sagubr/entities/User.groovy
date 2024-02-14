package github.sagubr.entities

import github.sagubr.services.PasswordEncoder
import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp

import java.time.LocalDateTime

@Entity
@Table(name = "users")
@Serdeable.Deserializable
class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id
    String username
    String password
    List<String> roles

    @CreationTimestamp
    LocalDateTime timestamp
    @Enumerated(EnumType.ORDINAL)
    Status status

}
