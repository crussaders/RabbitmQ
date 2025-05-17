package com.RabbitMQ.Configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_NAME = "Queue1";
    public static final String QUEUE_NAME_MOBILE = "Mobile";
    public static final String QUEUE_NAME_TV = "TV";
    public static final String QUEUE_NAME_AC = "AC";
    public static final List<String> QUEUE_NAMES = List.of(QUEUE_NAME_MOBILE,QUEUE_NAME_TV,QUEUE_NAME_AC);

//    @Bean
//    public Queue queue() {
//        return new Queue(QUEUE_NAME, true);
//    }
//
//    @Bean
//    public List<Queue> queue() {
//        return QUEUE_NAMES.stream().map(name -> new Queue(name, true)).collect(Collectors.toList());
//    }
@Bean
public Queue queueMobile() {
    return new Queue(QUEUE_NAME_MOBILE, true);
}

    //for conversion of messages to JSON

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }
}
