package com.sapient.productcataloguesearch.listener.impl;

import com.sapient.productcataloguesearch.events.SupplierChangeEvent;
import com.sapient.productcataloguesearch.events.handling.listeners.EventListener;

/**
 * EventListener interface is used to
 * create SupplierChangeLogger that respond to supplier change events:
 */
//public class SupplierChangeLogger implements SupplierChangeListener {
//
//    @Override
//    public void onSupplierChange ( Supplier supplier ) {
//        System.out.println("Supplier change event received for supplier: " + supplier.getName());
//        // Perform any other actions needed in response to the supplier change event
//    }
//}

public class SupplierChangeLogger implements EventListener<SupplierChangeEvent> {

    @Override
    public void onEvent( SupplierChangeEvent event) {
        System.out.println("onEvent() : Data refresh triggered : Supplier change event received for supplier: " + event.getSupplier().getName());
        // Perform any other actions needed in response to the supplier change event
    }
}

