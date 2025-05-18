package com.RabbitMQ.Controller;

import com.RabbitMQ.Publisher.RabbitMsgPublisher;
import com.RabbitMQ.dao.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RabbitMQController {

    @Autowired
    private RabbitMsgPublisher rabbitMsgPublisher;

//    @PostMapping("/publish")
//    public String publishMessage(@RequestParam String message) {
//        rabbitMsgPublisher.sendMessage(message);
//        return "Message Published: " + message;
//    }
//    @PostMapping("/publish")
//    public String publishMessage(@RequestBody Message message) {
//    //    rabbitMsgPublisher.sendMessage(message);
//        rabbitMsgPublisher.directPublish(message);
//        return "Message Published: " + message;
//    }
    @PostMapping("/publishFan")
    public String publishMessageFan(@RequestBody Message message) {
//    rabbitMsgPublisher.sendMessage(message);
        rabbitMsgPublisher.fanoutPublish(message);
        return "Message Published FanOut: " + message;
    }
}
