package com.sapient.productCatalogueSearch.repository;

import com.sapient.productCatalogueSearch.domain.Brand;
import com.sapient.productCatalogueSearch.domain.Category;
import com.sapient.productCatalogueSearch.events.BrandChangeEvent;
import com.sapient.productCatalogueSearch.events.SupplierChangeEvent;
import com.sapient.productCatalogueSearch.events.manage.and.notify.listeners.EventPublisher;
import org.springframework.data.jpa.repository.JpaRepository;

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

