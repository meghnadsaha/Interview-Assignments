package com.coding.oops.better.com.zoo.ticketing.domain;

public interface Ticket {
    void addGuest ( int age );

    void setTotalCost ( int totalCost );

    void displayTicketDetails ();

    void displayTicketDetailsForSecurity ();
}
