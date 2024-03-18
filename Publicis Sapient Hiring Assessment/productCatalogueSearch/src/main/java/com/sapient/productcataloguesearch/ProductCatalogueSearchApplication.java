package com.sapient.productcataloguesearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.sapient.productcataloguesearch.listener.impl"})
@SpringBootApplication
public class ProductCatalogueSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogueSearchApplication.class, args);
	}


}
