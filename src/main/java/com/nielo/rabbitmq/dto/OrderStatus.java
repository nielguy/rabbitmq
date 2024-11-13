package com.nielo.rabbitmq.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderStatus {

    private Order order;
    private String status;
    private String message;
}
