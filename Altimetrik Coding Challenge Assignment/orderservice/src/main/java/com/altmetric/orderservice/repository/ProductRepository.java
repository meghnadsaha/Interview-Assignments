package com.altmetric.orderservice.repository;

import com.altmetric.orderservice.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}

