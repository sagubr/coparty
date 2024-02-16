package github.sagubr.entity

import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable

@Introspected
class User {

    String username;
    String password
    String status
}
