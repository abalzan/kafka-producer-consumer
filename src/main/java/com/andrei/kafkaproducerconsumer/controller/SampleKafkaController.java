package com.andrei.kafkaproducerconsumer.controller;

import com.andrei.kafkaproducerconsumer.model.SampleKafkaModel;
import com.google.gson.Gson;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class SampleKafkaController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Gson jsonConverter;

    public SampleKafkaController(KafkaTemplate<String, String> kafkaTemplate, Gson jsonConverter) {
        this.kafkaTemplate = kafkaTemplate;
        this.jsonConverter = jsonConverter;
    }

    @PostMapping
    public void post(@RequestBody SampleKafkaModel model) {
        kafkaTemplate.send("TopicNameHere", jsonConverter.toJson(model));
    }

    @KafkaListener(topics = "TopicNameHere")
    public void getFromKafka(@RequestBody String model) {
        SampleKafkaModel sampleKafkaModel = jsonConverter.fromJson(model, SampleKafkaModel.class);
        System.out.println(sampleKafkaModel.toString());
    }
}
