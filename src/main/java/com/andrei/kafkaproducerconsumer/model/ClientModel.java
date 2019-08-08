package com.andrei.kafkaproducerconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientModel {

    private String name;
    private String surname;
    private String address;

}
