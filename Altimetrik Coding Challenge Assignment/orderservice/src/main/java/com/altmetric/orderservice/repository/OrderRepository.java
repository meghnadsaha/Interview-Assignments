package com.altmetric.orderservice.repository;

import com.altmetric.orderservice.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
