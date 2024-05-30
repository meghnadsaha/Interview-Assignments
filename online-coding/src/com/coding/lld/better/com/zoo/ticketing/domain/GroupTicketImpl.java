package com.coding.lld.better.com.zoo.ticketing.domain;

import java.util.ArrayList;
import java.util.List;

public class GroupTicketImpl implements GroupTicket {
    private String groupName;
    public List<Guest> guests;
    private int totalCost;

    public GroupTicketImpl ( int numGuests ) {
        guests = new ArrayList<>(numGuests);
    }

    @Override
    public void addGuest ( int age ) {
        guests.add(new GuestImpl(age));
    }

    @Override
    public void setTotalCost () {
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
        this.totalCost = totalCost;
    }

    @Override
    public int getTotalCost () {
        return totalCost;
    }


    @Override
    public void displayTicketDetails () {
        System.out.println("Group Name: " + groupName);
        for (int i = 0 ; i < guests.size() ; i++) {
            System.out.println("Guest " + (i + 1) + " (age: " + guests.get(i).getAge() + ")");
        }
        System.out.println("Total Charges: INR " + totalCost);
    }

    @Override
    public void displayTicketDetailsForSecurity () {
        System.out.println("Group Name: " + groupName);
        for (int i = 0 ; i < guests.size() ; i++) {
            System.out.println("Guest " + (i + 1) + " (age: " + guests.get(i).getAge() + ")");
        }
        System.out.println("Total Charges: INR " + totalCost);
    }

    @Override
    public void setGroupName ( String groupName ) {
        this.groupName = groupName;
    }

    @Override
    public String getGroupName () {
        return groupName;
    }
}
