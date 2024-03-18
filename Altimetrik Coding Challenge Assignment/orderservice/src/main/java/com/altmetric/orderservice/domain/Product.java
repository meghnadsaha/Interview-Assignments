package com.altmetric.orderservice.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String productId;
    private String name;
    private double price;
    private int stockQuantity ;
    // getters and setters
}

