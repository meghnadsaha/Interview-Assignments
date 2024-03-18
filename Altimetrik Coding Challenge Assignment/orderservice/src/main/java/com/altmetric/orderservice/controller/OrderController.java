package com.altmetric.orderservice.controller;


import com.altmetric.orderservice.domain.Order;
import com.altmetric.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public CompletableFuture<Order> createOrder ( @RequestParam String productId , @RequestParam String customerId ) {
        return orderService.createOrderAsync(productId , customerId);
    }

    @GetMapping("/{orderId}")
    public CompletableFuture<Order> getOrderByOrderId ( @PathVariable String orderId ) {
        return orderService.getOrderDetailsAsync(orderId);
    }

    // Implement other CRUD endpoints as needed
}

