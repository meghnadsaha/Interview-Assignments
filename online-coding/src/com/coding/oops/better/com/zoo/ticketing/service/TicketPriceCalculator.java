package com.coding.oops.better.com.zoo.ticketing.service;

import com.coding.oops.better.com.zoo.ticketing.domain.Guest;

public class TicketPriceCalculator {
    public int calculateTotalCost ( Guest[] guests ) {
        int totalCost = 0;
        for (Guest guest : guests) {
            if (guest.getAge() <= 2) {
                totalCost += 0;
            } else if (guest.getAge() < 18) {
                totalCost += 100;
            } else if (guest.getAge() < 60) {
                totalCost += 500;
            } else {
                totalCost += 300;
            }
        }
        return totalCost;
    }
}
