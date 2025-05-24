package com.RabbitMQ.Controller;

import com.RabbitMQ.Publisher.RabbitMsgPublisher;
import com.RabbitMQ.dao.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
//        rabbitMsgPublisher.directPublish(message);
//        return "Message Published: " + message;
//    }
//    @PostMapping("/publishFan")
//    public String publishMessageFan(@RequestBody Message message) {
//        rabbitMsgPublisher.fanoutPublish(message);
//        return "Message Published FanOut: " + message;
//    }

//    @PostMapping("/publishTopic")
//    public ResponseEntity<Message> publishMessageFan(@RequestBody Message message) {
//        rabbitMsgPublisher.topicPublish(message);
//        return ResponseEntity.ok(message);
//    }
//    @PostMapping("/publishHeader")
//    public String publishMessageFan(@RequestBody Message message) throws JsonProcessingException {
//        rabbitMsgPublisher.headerPublish(message);
//        return "Message Published Header: " + message;
//    }
}
