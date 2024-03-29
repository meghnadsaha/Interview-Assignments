package com.sapient.productcataloguesearch.service;

import com.sapient.productcataloguesearch.domain.Brand;
import com.sapient.productcataloguesearch.events.BrandChangeEvent;
import com.sapient.productcataloguesearch.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BrandService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;
    @Autowired
    private BrandRepository brandRepository;

    public Brand addBrand ( Brand brand ) {
        // Save brand to database
//        Brand savedBrand = brandRepository.save(brand);
        System.out.println("Save brand to database");
        // Publish brand change event
        eventPublisher.publishEvent(new BrandChangeEvent(brand));
        return brand;
    }

    public List<Brand> getAllBrands () {
        System.out.println("Get All Brands..");
        return Arrays.asList();
        //brandRepository.findAll();
    }

    // Other methods...
}

