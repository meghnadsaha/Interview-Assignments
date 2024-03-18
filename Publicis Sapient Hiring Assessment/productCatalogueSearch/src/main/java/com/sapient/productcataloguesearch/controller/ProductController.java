package com.sapient.productcataloguesearch.controller;

import com.sapient.productcataloguesearch.domain.Product;
import com.sapient.productcataloguesearch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/search/brand/{brandId}")
    public List<Product> searchByBrand( @PathVariable Long brandId) {
        return productService.searchByBrand(brandId);
    }

    @GetMapping("/search/color/{color}")
    public List<Product> searchByColor(@PathVariable String color) {
        return productService.searchByColor(color);
    }

    @GetMapping("/search/size/{size}")
    public List<Product> searchBySize(@PathVariable String size) {
        return productService.searchBySize(size);
    }

    @GetMapping("/{sku}")
    public Product getBySku(@PathVariable String sku) {
        return productService.getBySku(sku);
    }

//    @GetMapping("/search/supplier/{supplierId}")
//    public List<Product> searchBySupplier(@PathVariable Long supplierId) {
//        return productService.searchBySupplier(supplierId);
//    }
}
