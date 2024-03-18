package com.sapient.productcataloguesearch.repository;

import com.sapient.productcataloguesearch.domain.Brand;
import com.sapient.productcataloguesearch.events.BrandChangeEvent;
import com.sapient.productcataloguesearch.events.manage.and.notify.listeners.EventPublisher;

/**
 * Implementation of  BrandRepository is to use the EventPublisher to trigger events..
 */
public class BrandRepository {
    //implements JpaRepository<Brand, Long> {
    private EventPublisher<BrandChangeEvent> eventPublisher;

    public BrandRepository ( EventPublisher<BrandChangeEvent> eventPublisher ) {
        this.eventPublisher = eventPublisher;
    }

    public void addBrand ( Brand brand ) {
        // Add brand logic
        // Trigger brand change event
        System.out.println("addBrand(): Trigger brand change event....");
        eventPublisher.publishEvent(new BrandChangeEvent(brand));

    }
}

