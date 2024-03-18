package com.sapient.productcataloguesearch.listener.impl;


import com.sapient.productcataloguesearch.events.BrandChangeEvent;
import com.sapient.productcataloguesearch.events.handling.listeners.EventListener;

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


