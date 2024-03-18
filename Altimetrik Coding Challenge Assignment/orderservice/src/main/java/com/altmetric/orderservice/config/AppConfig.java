package com.altmetric.orderservice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class AppConfig {

    @Bean
    public Executor executor () {
        return Executors.newFixedThreadPool(10); // Create a fixed thread pool with 10 threads
    }
}
