package com.altmetric.orderservice.service;


import com.altmetric.orderservice.domain.Customer;
import com.altmetric.orderservice.domain.Order;
import com.altmetric.orderservice.domain.Product;
import com.altmetric.orderservice.repository.CustomerRepository;
import com.altmetric.orderservice.repository.OrderRepository;
import com.altmetric.orderservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private Executor executor; // Inject Executor bean

    public CompletableFuture<Order> createOrderAsync ( String productId , String customerId ) {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate some processing delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Assuming createOrder method saves order in database
            return createOrder(productId , customerId);
        } , executor);
    }

    public Order createOrder ( String productId , String customerId ) {
        Product product = productRepository.findById(productId).orElse(null);
        Customer customer = customerRepository.findById(customerId).orElse(null);

        if (product == null || customer == null) {
            return null; // Handle error
        }

        Order order = new Order();
        order.setProduct(product);
        order.setCustomer(customer);


        Order createdOrder = orderRepository.save(order);
        return createdOrder;
//        if (createdOrder != null) {
//            return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
    }


    public CompletableFuture<Order> getOrderDetailsAsync(String orderId) {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate some processing delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Assuming getOrderDetails method retrieves order details from database
            return getOrderDetails(orderId);
        }, executor);
    }

    private Order getOrderDetails(String orderId) {
        // Implement logic to fetch order details
        return orderRepository.findById(orderId).orElse(null); // Placeholder for actual implementation
    }

}
