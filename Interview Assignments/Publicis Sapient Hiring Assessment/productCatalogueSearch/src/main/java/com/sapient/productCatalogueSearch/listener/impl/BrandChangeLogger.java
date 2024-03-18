package com.sapient.productCatalogueSearch.listener.impl;


import com.sapient.productCatalogueSearch.domain.Brand;
import com.sapient.productCatalogueSearch.events.BrandChangeEvent;
import com.sapient.productCatalogueSearch.events.handling.listeners.EventListener;
import com.sapient.productCatalogueSearch.listener.BrandChangeListener;

/**
 * EventListener interface is used to
 * create BrandChangeLogger that respond to brand change events:
 */
public class BrandChangeLogger implements EventListener<BrandChangeEvent> {

    @Override
    public void onEvent(BrandChangeEvent event) {

        System.out.println("onEvent() : Data refresh triggered : Brand change event received for brand: " + event.getBrand().getName());
        // Perform any other actions needed in response to the brand change event
    }
}


