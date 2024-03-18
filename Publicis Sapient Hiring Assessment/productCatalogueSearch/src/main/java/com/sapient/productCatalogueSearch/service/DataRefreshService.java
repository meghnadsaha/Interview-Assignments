package com.sapient.productCatalogueSearch.service;


import com.sapient.productCatalogueSearch.domain.Brand;
import com.sapient.productCatalogueSearch.domain.Supplier;
import com.sapient.productCatalogueSearch.events.BrandChangeEvent;
import com.sapient.productCatalogueSearch.events.SupplierChangeEvent;
import com.sapient.productCatalogueSearch.events.manage.and.notify.listeners.EventPublisher;
import com.sapient.productCatalogueSearch.listener.impl.BrandChangeLogger;
import com.sapient.productCatalogueSearch.listener.impl.SupplierChangeLogger;
import com.sapient.productCatalogueSearch.repository.BrandRepository;
import com.sapient.productCatalogueSearch.repository.SupplierRepository;

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
