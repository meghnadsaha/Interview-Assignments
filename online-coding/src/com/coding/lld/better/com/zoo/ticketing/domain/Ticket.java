package com.coding.lld.better.com.zoo.ticketing.domain;

public interface Ticket {
    void addGuest ( int age );

    void setTotalCost();
    int getTotalCost();
    void displayTicketDetails ();

    void displayTicketDetailsForSecurity ();
}
