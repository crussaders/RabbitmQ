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

//    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
//    public void receiveMessage(Message message) {
//        messageProcess(message);
//        System.out.println("Received message: " + message);
//    }
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME_MOBILE)
    public void receiveMessageMobile(Message message) {
        messageProcess(message);
        System.out.println("Received message Mobile: " + message);
    }
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME_TV)
    public void receiveMessageTV(Message message) {
        messageProcess(message);
        System.out.println("Received message TV: " + message);
    }
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME_AC)
    public void receiveMessageAC(Message message) {
        messageProcess(message);
        System.out.println("Received message AC: " + message);
    }

    public void messageProcess(Message message) {
        String firstname = message.getFirstName();
        if(!firstname.equals(firstname.toUpperCase())) {
            String upper =  message.getFirstName().toUpperCase();
            message.setFirstName(upper);
            System.out.println("Processed message: " + message.getFirstName());
        }
    }
//    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
//    public void receiveMessage(String message) {
//        System.out.println("Received message: " + message);
//    }
}
