package com.nielo.rabbitmq.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Order {

    private String orderId;
    private String name;
    private int quantity;
    private double price;
}
