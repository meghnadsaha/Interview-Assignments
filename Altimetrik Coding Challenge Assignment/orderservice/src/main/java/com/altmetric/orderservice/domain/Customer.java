package com.altmetric.orderservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;
    // getters and setters
}
