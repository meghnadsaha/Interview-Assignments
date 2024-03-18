package com.sapient.productCatalogueSearch.events;

import com.sapient.productCatalogueSearch.domain.Supplier;
import org.springframework.context.ApplicationEvent;

public class SupplierChangeEvent extends ApplicationEvent {
    private Supplier supplier;

    public SupplierChangeEvent ( Supplier supplier ) {
        super(supplier);
        this.supplier = supplier;
    }

    public Supplier getSupplier () {
        return supplier;
    }
}
