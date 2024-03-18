package com.sapient.productCatalogueSearch.events.manage.and.notify.listeners;

import com.sapient.productCatalogueSearch.events.handling.listeners.EventListener;

import java.util.ArrayList;
import java.util.List;

/**
 *  EventPublisher class that will manage listeners and notify them when events occur:
 *
 * @param <T>
 */
public class EventPublisher<T> {
    private List<EventListener<T>> listeners = new ArrayList<>();

    public void addListener ( EventListener<T> listener ) {
        listeners.add(listener);
    }

    public void removeListener ( EventListener<T> listener ) {
        listeners.remove(listener);
    }

    public void publishEvent ( T event ) {
        for (EventListener<T> listener : listeners) {
            listener.onEvent(event);
        }
    }
}
