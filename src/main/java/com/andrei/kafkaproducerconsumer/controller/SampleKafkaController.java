package com.andrei.kafkaproducerconsumer.controller;

import com.andrei.kafkaproducerconsumer.model.BookModel;
import com.andrei.kafkaproducerconsumer.model.ClientModel;
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
    public void post(@RequestBody ClientModel model) {
        kafkaTemplate.send("ClientTopic", jsonConverter.toJson(model));
    }

    @PostMapping("/v2")
    public void post(@RequestBody BookModel model) {
        kafkaTemplate.send("BookTopic", jsonConverter.toJson(model));
    }

    @KafkaListener(topics = {"ClientTopic", "BookTopic"})
    public void getFromKafka(@RequestBody String model) {
        Object clientModel = jsonConverter.fromJson(model, Object.class);
        System.out.println(clientModel.toString());
    }
}
