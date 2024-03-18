package com.altmetric.orderservice.controller;

import com.altmetric.orderservice.domain.Product;
import com.altmetric.orderservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts () {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById ( @PathVariable String id ) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct ( @RequestBody Product product ) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct ( @PathVariable String id , @RequestBody Product product ) {
        return productService.updateProduct(id , product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct ( @PathVariable String id ) {
        productService.deleteProduct(id);
    }
}
