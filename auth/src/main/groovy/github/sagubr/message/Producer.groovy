package github.sagubr.message

import github.sagubr.entity.User
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
interface Producer {

    @Topic("users")
    void send(User user);
}

