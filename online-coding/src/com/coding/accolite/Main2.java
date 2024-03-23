package com.coding.accolite;


import java.util.HashMap;
import java.util.Objects;

public class Main2 {
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.setEid(1);
        HashMap<Employee, Boolean> hm = new HashMap<>();
        hm.put(emp1, true);
        emp1.setEid(2);
        System.out.println(hm.get(emp1)); // Output: ??
    }

    static class Employee {
        private int eid;

        @Override
        public boolean equals ( Object o ) {
            if (this == o) return true;
            if (!(o instanceof Employee employee)) return false;
            return getEid() == employee.getEid();
        }

        @Override
        public int hashCode () {
            return Objects.hash(getEid());
        }

        public int getEid() {
            return eid;
        }

        public void setEid(int eid) {
            this.eid = eid;
        }

        // hashCode and equals methods not overridden
    }
}
