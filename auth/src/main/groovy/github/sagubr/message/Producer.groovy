package github.sagubr.message

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface Producer {

    @Topic("users")
    void send(String message);
}

