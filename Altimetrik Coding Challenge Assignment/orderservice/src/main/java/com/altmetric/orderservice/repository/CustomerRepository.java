package com.altmetric.orderservice.repository;

import com.altmetric.orderservice.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
