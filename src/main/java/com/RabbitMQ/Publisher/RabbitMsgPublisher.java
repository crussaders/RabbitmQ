package com.RabbitMQ.Publisher;

import com.RabbitMQ.Configuration.RabbitMQConfig;
import com.RabbitMQ.dao.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.AMQP.BasicProperties;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

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
//    public void headerPublish(Message message) throws JsonProcessingException {
//        // 1. Convert payload to JSON
//        String json = new ObjectMapper().writeValueAsString(message);
//
//        // 2. Set up headers
//        MessageProperties props = new MessageProperties();
//        props.setContentType("application/json");
//
//        // ✅ Set your custom headers
//        Map<String, Object> headersMap = new HashMap<>();
//        headersMap.put("item1", "mobile");
//        headersMap.put("item2", "television");
//        headersMap.forEach(props::setHeader); // set each header
//
//        // 3. Build message
//        Message payload = new Message(json.getBytes(StandardCharsets.UTF_8), props);
//
//        // 4. Send to headers exchange (routing key is ignored)
//        rabbitTemplate.convertAndSend("Header-Exchange", "", message);
//
//        System.out.println("Header-Exchange published message: " + json + " with headers: " + headersMap);
//    }

//
//    public void sendMessage(String message) {
//        rabbitTemplate.convertAndSend("", RabbitMQConfig.QUEUE_NAME, message);
//        System.out.println("Sent Message: " + message);
//    }
}
