package com.RabbitMQ.Consumer;

import com.RabbitMQ.Configuration.RabbitMQConfig;
import com.RabbitMQ.dao.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMsgConsumer {

//    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
//    public void receiveMessage(Message message) {
//        System.out.println("Received message: " + message);
//    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(Message message) {
        String firstname = message.getFirstName();
        if(!firstname.equals(firstname.toUpperCase())) {
            String upper =  message.getFirstName().toUpperCase();
            message.setFirstName(upper);
            System.out.println("Processed message: " + message.getFirstName());
        }
        System.out.println("Received message: " + message);
    }

//    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
//    public void receiveMessage(String message) {
//        System.out.println("Received message: " + message);
//    }
}
