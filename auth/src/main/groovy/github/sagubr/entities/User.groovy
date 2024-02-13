package github.sagubr.entities

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp

import java.nio.charset.StandardCharsets
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

    @PrePersist
    void encodePassword() {
        this.password = Base64.encoder
                .encodeToString(this.password.getBytes(StandardCharsets.UTF_8))
    }

}
