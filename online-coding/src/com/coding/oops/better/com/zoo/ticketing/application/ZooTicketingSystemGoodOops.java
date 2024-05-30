package com.coding.oops.better.com.zoo.ticketing.application;

import com.coding.oops.better.com.zoo.ticketing.domain.GroupTicket;
import com.coding.oops.better.com.zoo.ticketing.domain.GroupTicketImpl;
import com.coding.oops.better.com.zoo.ticketing.domain.Guest;
import com.coding.oops.better.com.zoo.ticketing.domain.Ticket;
import com.coding.oops.better.com.zoo.ticketing.service.TicketPriceCalculator;

import java.util.Scanner;

public class ZooTicketingSystemGoodOops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ticket ticket = null;
        TicketPriceCalculator calculator = new TicketPriceCalculator();

        while (true) {
            System.out.println("\n--- Zoo Ticketing System  ---");
            System.out.println("1.  Issue a new ticket");
            System.out.println("2.  Validate a ticket");
            System.out.println("3.  Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    ticket = issueTicket(scanner);
                    break;
                case 2:
                    validateTicket(ticket);
                    break;
                case 3:
                    System.out.println("Exiting Zoo Ticketing System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    public static Ticket issueTicket(Scanner scanner) {
        System.out.print("Enter the number of guests: ");
        int numGuests = scanner.nextInt();
        System.out.print("Is this a group ticket? (yes/no): ");
        String isGroupTicket = scanner.next();

        if ("yes".equalsIgnoreCase(isGroupTicket)) {
            return issueGroupTicket(scanner, numGuests);
        } else {
            return issueIndividualTicket(scanner, numGuests);
        }
    }

    public static Ticket issueIndividualTicket(Scanner scanner, int numGuests) {
        Ticket ticket = new GroupTicketImpl(numGuests);

        for (int i = 0; i < numGuests; i++) {
            System.out.print("Enter age of guest " + (i + 1) + ": ");
            int age = scanner.nextInt();
            ticket.addGuest(age);
        }

        TicketPriceCalculator calculator = new TicketPriceCalculator();
        ticket.setTotalCost(calculator.calculateTotalCost(((GroupTicketImpl) ticket).guests.toArray(new Guest[0])));

        System.out.println("\nTicket Issued Successfully!");
        System.out.println("Ticket Details:");
        ticket.displayTicketDetails();

        return ticket;
    }

    public static Ticket issueGroupTicket(Scanner scanner, int numGuests) {
        System.out.print("Enter group name: ");
        String groupName = scanner.next();

        GroupTicket ticket = new GroupTicketImpl(numGuests);
        ticket.setGroupName(groupName);

        for (int i = 0; i < numGuests; i++) {
            System.out.print("Enter age of guest " + (i + 1) + ": ");
            int age = scanner.nextInt();
            ticket.addGuest(age);
        }

        TicketPriceCalculator calculator = new TicketPriceCalculator();
        ticket.setTotalCost(calculator.calculateTotalCost(((GroupTicketImpl) ticket).guests.toArray(new Guest[0])));

        System.out.println("\nGroup Ticket Issued Successfully!");
        System.out.println("Ticket Details:");
        ticket.displayTicketDetails();

        return ticket;
    }

    public static void validateTicket(Ticket ticket) {
        if (ticket == null) {
            System.out.println("No ticket issued yet. Please issue a ticket first.");
        } else {
            System.out.println("\nTicket Validated Successfully!");
            System.out.println("Ticket Details:");
            ticket.displayTicketDetailsForSecurity();
        }
    }
}

