package com.learn.kafkademo.controller;

import com.learn.kafkademo.entity.Student;
import com.learn.kafkademo.producer.KafkaJsonProducer;
import com.learn.kafkademo.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
@RestController
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping()
    public ResponseEntity<String> sendMessage(
            @RequestBody String message
    ) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message queued successfully");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJson(
            @RequestBody Student student
    ) {
        kafkaJsonProducer.sendMessage(student);
        return ResponseEntity.ok("Json queued successfully");
    }
}
