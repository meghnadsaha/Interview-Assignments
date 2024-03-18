package com.sapient.productCatalogueSearch.service;

import com.sapient.productCatalogueSearch.domain.Supplier;
import com.sapient.productCatalogueSearch.events.SupplierChangeEvent;
import com.sapient.productCatalogueSearch.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;
    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier addSupplier ( Supplier supplier ) {
        // Save supplier to database
        //Supplier savedSupplier = supplierRepository.save(supplier);
        System.out.println("Save supplier to database..");
        // Publish supplier change event
        eventPublisher.publishEvent(new SupplierChangeEvent(supplier));
        return supplier;
    }

    // Other methods...
}
