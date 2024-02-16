package github.sagubr.message

import github.sagubr.entity.User
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
class MessageConsumer {

    private final Logger LOG = LoggerFactory.getLogger(MessageConsumer.class)

    @Topic("users")
    void receive(User user) {
        System.out.println("Received Message   - " + time + " and " + message);
    }
}
