package com.sapient.productcataloguesearch.controller;

import com.sapient.productcataloguesearch.domain.Brand;
import com.sapient.productcataloguesearch.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {
    @Autowired
        private BrandService brandService;

    @GetMapping("/")
    public List<Brand> getAllBrands () {
        return brandService.getAllBrands();
    }

    @PostMapping("/")
    public Brand addBrand ( @RequestBody Brand brand ) {
        return brandService.addBrand(brand);
    }
}

