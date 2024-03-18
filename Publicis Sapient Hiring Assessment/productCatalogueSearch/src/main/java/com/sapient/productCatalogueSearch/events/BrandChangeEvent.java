package com.sapient.productCatalogueSearch.events;


import com.sapient.productCatalogueSearch.domain.Brand;
import org.springframework.context.ApplicationEvent;

public class BrandChangeEvent extends ApplicationEvent {
    private Brand brand;

    public BrandChangeEvent(Brand brand) {
        super(brand);
        this.brand = brand;
    }

    public Brand getBrand() {
        return brand;
    }
}

