package com.sapient.productcataloguesearch.repository;

import com.sapient.productcataloguesearch.domain.Supplier;
import com.sapient.productcataloguesearch.events.SupplierChangeEvent;
import com.sapient.productcataloguesearch.events.manage.and.notify.listeners.EventPublisher;

/**
 * Implementation of SupplierRepository is to use the EventPublisher to trigger events..
 */
public class SupplierRepository {
    private EventPublisher<SupplierChangeEvent> eventPublisher;

    public SupplierRepository( EventPublisher<SupplierChangeEvent> eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void addSupplier(Supplier supplier) {
        // Add supplier logic
        // Trigger supplier change event
        System.out.println("addSupplier(): Trigger supplier change event....");
        eventPublisher.publishEvent(new SupplierChangeEvent(supplier));
    }
}
