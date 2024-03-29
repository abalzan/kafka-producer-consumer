package com.andrei.kafkaproducerconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookModel {
    private String title;
    private String author;
    private String description;
}
