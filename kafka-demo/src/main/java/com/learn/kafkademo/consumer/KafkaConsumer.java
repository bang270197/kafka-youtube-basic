package com.learn.kafkademo.consumer;

import com.learn.kafkademo.entity.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {
//    @KafkaListener(topics = "topic1", groupId = "myGroup")
//    public void consumerMsg(String msg){
//        log.info(format("======= Consuming the message from topic1 %s ======", msg));
//    }

    @KafkaListener(topics = "topic1", groupId = "myGroup")
    public void consumerJsonMsg(Student student){
        log.info(format("======= Consuming the message from second_topic %s ======", student.toString()));
    }
}
