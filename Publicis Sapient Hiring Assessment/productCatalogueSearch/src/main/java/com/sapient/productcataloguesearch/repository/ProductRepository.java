package com.sapient.productcataloguesearch.repository;

import com.sapient.productcataloguesearch.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByBrandId( Long brandId);
    List<Product> findByColor( String color);
    List<Product> findBySize(String size);
    Product findBySku(String sku);
//    List<Product> findByProductSuppliers_SupplierId(Long supplierId);
}

