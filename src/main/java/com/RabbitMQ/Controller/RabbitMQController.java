package com.RabbitMQ.Controller;

import com.RabbitMQ.Publisher.RabbitMsgPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RabbitMQController {

    @Autowired
    private RabbitMsgPublisher rabbitMsgPublisher;

    @PostMapping("/publish")
    public String publishMessage(@RequestParam String message) {
        rabbitMsgPublisher.sendMessage(message);
        return "Message Published: " + message;
    }
}
