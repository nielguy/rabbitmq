package com.nielo.rabbitmq.consumer;

import com.nielo.rabbitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "niel_queue")
public class User {

    @RabbitHandler
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message received from queue : "+orderStatus);
    }
}
