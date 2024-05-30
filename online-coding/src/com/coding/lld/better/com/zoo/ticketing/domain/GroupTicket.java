package com.coding.lld.better.com.zoo.ticketing.domain;

public interface GroupTicket extends Ticket {
    void setGroupName ( String groupName );

    String getGroupName ();

    class GuestImpl implements Guest {
        private int age;

        public GuestImpl(int age) {
            setAge(age);
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
            this.age = age;
        }
    }
}
