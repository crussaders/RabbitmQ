package com.RabbitMQ.Publisher;

import com.RabbitMQ.Configuration.RabbitMQConfig;
import com.RabbitMQ.dao.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMsgPublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(Message message) {
        rabbitTemplate.convertAndSend("", RabbitMQConfig.QUEUE_NAME, message);
        System.out.println("Sent Message: " + message);
    }

    public void directPublish(Message message) {

        rabbitTemplate.convertAndSend("Direct-Exchange",message.getKeys(), message);
        System.out.println("Direct-message: " + message );
    }

//
//    public void sendMessage(String message) {
//        rabbitTemplate.convertAndSend("", RabbitMQConfig.QUEUE_NAME, message);
//        System.out.println("Sent Message: " + message);
//    }
}
