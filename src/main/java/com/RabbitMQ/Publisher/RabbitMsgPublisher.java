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
        System.out.println("Direct-Exchange: " + message );
    }

    public void fanoutPublish(Message message) {
        rabbitTemplate.convertAndSend("Fanout-Exchange","",message);
        System.out.println("Fanout-Exchange: " + message);
    }
    public void topicPublish(Message message) {
        rabbitTemplate.convertAndSend("Topic-Exchange","tv.mobile.ac",message);
        System.out.println("Topic-Exchange: " + message);
    }

//
//    public void sendMessage(String message) {
//        rabbitTemplate.convertAndSend("", RabbitMQConfig.QUEUE_NAME, message);
//        System.out.println("Sent Message: " + message);
//    }
}
