package com.altmetric.orderservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "orders")
public class Order {
    @Id
    private String id;

    @DBRef
    private Product product;

    @DBRef
    private Customer customer;

    // getters and setters
}
