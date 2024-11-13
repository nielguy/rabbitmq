package com.nielo.rabbitmq.publisher;

import com.nielo.rabbitmq.dto.Order;
import com.nielo.rabbitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Value("${topic.exchange}")
    private String EXCHANGE;

    @Value("${routing.key}")
    private String ROUTING_KEY;


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
        order.setOrderId(UUID.randomUUID().toString());

        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed successfully in "+restaurantName);
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, orderStatus);
        return "Success !!";
    }
}
