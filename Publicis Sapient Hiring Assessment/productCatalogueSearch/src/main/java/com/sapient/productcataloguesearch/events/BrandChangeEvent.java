package com.sapient.productcataloguesearch.events;


import com.sapient.productcataloguesearch.domain.Brand;
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

