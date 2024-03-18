package com.altmetric.orderservice.service;

import com.altmetric.orderservice.domain.Product;
import com.altmetric.orderservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(String id, Product product) {
        if (productRepository.existsById(id)) {
//            product.setId(id);
            return productRepository.save(product);
        }
        return null; // Handle error
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
