package com.sapient.productcataloguesearch.service;


import com.sapient.productcataloguesearch.domain.Brand;
import com.sapient.productcataloguesearch.domain.Supplier;
import com.sapient.productcataloguesearch.events.BrandChangeEvent;
import com.sapient.productcataloguesearch.events.SupplierChangeEvent;
import com.sapient.productcataloguesearch.events.manage.and.notify.listeners.EventPublisher;
import com.sapient.productcataloguesearch.listener.impl.BrandChangeLogger;
import com.sapient.productcataloguesearch.listener.impl.SupplierChangeLogger;
import com.sapient.productcataloguesearch.repository.BrandRepository;
import com.sapient.productcataloguesearch.repository.SupplierRepository;

import org.springframework.stereotype.Service;

@Service
public class DataRefreshService {

    public static void main ( String[] args ) {
        EventPublisher<BrandChangeEvent> brandEventPublisher = new EventPublisher<>();
        BrandRepository brandRepository = new BrandRepository(brandEventPublisher);
        brandEventPublisher.addListener(new BrandChangeLogger());

        EventPublisher<SupplierChangeEvent> supplierEventPublisher = new EventPublisher<>();
        SupplierRepository supplierRepository = new SupplierRepository(supplierEventPublisher);
        supplierEventPublisher.addListener(new SupplierChangeLogger());

        /**
         * Data will come from multiple suppliers -
         * This should trigger data refresh should happen on addition / deletion of brand or supplier
         */
        // Simulate adding a brand and a supplier
        brandRepository.addBrand(new Brand("Dell"));
        supplierRepository.addSupplier(new Supplier("Japanese"));
    }
}
