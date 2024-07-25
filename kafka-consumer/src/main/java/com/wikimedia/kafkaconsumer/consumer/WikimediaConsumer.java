package com.wikimedia.kafkaconsumer.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class WikimediaConsumer {
        @KafkaListener(topics = "wikimedia-stream", groupId = "myGroup")
    public void consumerMsg(String msg){
        log.info(format("======= Consuming the message from wikimedia-stream %s ======", msg));
    }
}
