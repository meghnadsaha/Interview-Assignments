
1.  Get the lowest and highest amount record for each name. output must
    > be sorted by amounts in ascending order for each name

  ------------------------------------------------------------------------
ID         Name       created_on                  Amount
  ---------- ---------- --------------------------- ----------------------
A1         A          2023-04-01                  10

A2         A          2023-04-02                  20

A3         A          2023-04-03                  50

A4         Ase        2023-04-04                  30

A5         A          2023-04-05                  12

A6         A          2023-04-06                  5

B1         B          2023-04-01                  10

B2         B          2023-04-02                  0

B3         B          2023-04-03                  25

B4         B          2023-04-04                  20

------------------------------------------------------------------------

Expected output:

  -------------------------------------------------------------------------
ID            name          created_on              Amount
  ------------- ------------- ----------------------- ---------------------
A6            A             2023-04-06              5

A3            A             2023-04-03              50

B2            B             2023-04-02              0

B3            B             2023-04-03              25

-------------------------------------------------------------------------

> Query

```sql

CREATE TABLE your_table_name (
    ID VARCHAR(10),
    Name VARCHAR(10),
    created_on DATE,
    Amount INT
);


INSERT INTO your_table_name (ID, Name, created_on, Amount) VALUES
('A1', 'A', '2023-04-01', 10),
('A2', 'A', '2023-04-02', 20),
('A3', 'A', '2023-04-03', 50),
('A4', 'Ase', '2023-04-04', 30),
('A5', 'A', '2023-04-05', 12),
('A6', 'A', '2023-04-06', 5),
('B1', 'B', '2023-04-01', 10),
('B2', 'B', '2023-04-02', 0),
('B3', 'B', '2023-04-03', 25),
('B4', 'B', '2023-04-04', 20);


WITH min_max_amounts AS (
    SELECT
        Name,
        MIN(Amount) AS min_amount,
        MAX(Amount) AS max_amount
    FROM
        your_table_name
    GROUP BY
        Name
)
SELECT
    t.ID,
    t.Name,
    t.created_on,
    t.Amount
FROM
    your_table_name t
    JOIN min_max_amounts m ON t.Name = m.Name
WHERE
    t.Amount = m.min_amount OR t.Amount = m.max_amount
ORDER BY
    t.Name,
    t.Amount ASC;

```
2. [Minimum number of jumps to reach end (Jump Game)](https://leetcode.com/problems/jump-game-ii/description/)
   [Alternative ](https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/)

   

3. Consider the following Java code:-
   What will be the output of the code? Explain your answer.


```java
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> obj = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            obj.add(i);
        }

        changeElement(obj);

        // print arraylist using for loop
        for (Integer element : obj) {
            System.out.println(element);
        }
    }

    static void changeElement(ArrayList<Integer> obj) {
        for (int i = 10; i < 20; i++) {
            obj.add(i);
        }

        obj = null;
    }
}
```

> Output
```java
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 
```
`obj = null;`
 This line does not affect the original reference to the ArrayList.
 Assigning obj to null inside the changeElement method does not affect the original 
obj reference in the main method, as Java passes object references by value.



---

4. Here's a possible question based on the scenario:

---

Consider the following Java code:

```java
public class Main {
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

        public int getEid() {
            return eid;
        }

        public void setEid(int eid) {
            this.eid = eid;
        }

        // hashCode and equals methods not overridden
    }
}
```

Assuming the `hashCode` and `equals` methods are not overridden in the `Employee` class, what will be the output of the code? Explain your answer.

---

