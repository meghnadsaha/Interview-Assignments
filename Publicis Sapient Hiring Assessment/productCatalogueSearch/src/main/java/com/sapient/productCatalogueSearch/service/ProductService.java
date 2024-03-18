package com.sapient.productCatalogueSearch.service;

import com.sapient.productCatalogueSearch.domain.Product;
import com.sapient.productCatalogueSearch.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> searchByBrand ( Long brandId ) {
        return productRepository.findByBrandId(brandId);
    }

    public List<Product> searchByColor ( String color ) {
        return productRepository.findByColor(color);
    }

    public List<Product> searchBySize ( String size ) {
        return productRepository.findBySize(size);
    }

    public Product getBySku ( String sku ) {
        return productRepository.findBySku(sku);
    }

    //    public List<Product> searchBySupplier(Long supplierId) {
//        return productRepository.findByProductSuppliers_SupplierId(supplierId);
//    }
    public void refreshDataForBrand ( Long brandId ) {
        List<Product> products = productRepository.findByBrandId(brandId);
        for (Product product : products) {
            // Perform any necessary logic to refresh the data for the product
            // For example, you might update the product's information or status
//            product.setLastRefreshedTimestamp(LocalDateTime.now());
            // Save the updated product
            productRepository.save(product);
        }
    }
}
