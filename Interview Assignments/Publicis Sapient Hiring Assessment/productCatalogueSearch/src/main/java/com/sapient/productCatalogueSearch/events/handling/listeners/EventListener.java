package com.sapient.productCatalogueSearch.events.handling.listeners;

/**
 * Define an EventListener interface that will be implemented by classes interested in receiving events:
 *
 * @param <T>
 */
public interface EventListener<T> {
    void onEvent ( T event );
}
