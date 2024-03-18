package com.sapient.productcataloguesearch.events;

import com.sapient.productcataloguesearch.domain.Supplier;
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
