package com.RabbitMQ.Configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_NAME = "Queue1";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }
}
