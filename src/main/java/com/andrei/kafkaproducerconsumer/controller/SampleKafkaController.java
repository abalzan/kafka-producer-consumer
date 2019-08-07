package com.andrei.kafkaproducerconsumer.controller;

import com.andrei.kafkaproducerconsumer.model.SampleKafkaModel;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class SampleKafkaController {

    private final KafkaTemplate<String, SampleKafkaModel> kafkaTemplate;

    public SampleKafkaController(KafkaTemplate<String, SampleKafkaModel> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void post(@RequestBody SampleKafkaModel model) {
        kafkaTemplate.send("TopicNameHere", model);
    }
}
