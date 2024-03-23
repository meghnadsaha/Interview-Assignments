
---

**Question:** You have a text file containing employee details, with each line formatted as follows: `<ID>,<Name>,<Salary>`. Write a Java program to read this file, create an `Employee` object for each line, and store all employees in a list. Finally, serialize the list of employees into a file named `employees.ser`. Assume that the `Employee` class has already been defined with attributes for ID, name, and salary.

**Follow-up:** How would you modify the program if the text file format changed to `<Name>,<Salary>,<ID>`? How could you ensure that the program handles this change gracefully without modifying the existing `Employee` class?

---

This question tests the candidate's understanding of file I/O, serialization, and handling potential changes in the input file format. It also encourages them to think about maintainability and extensibility in their code.


To read a text file of employee details in Java using Java 8 features and store each employee as an object with the specified attributes, you can use the `Files.lines()` method along with streams to process the lines and create `Employee` objects. Here's how you can do it:

```java
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ReadTextFile {
    public static void main(String[] args) {
        String fileName = "employee.txt"; // Your text file path

        try {
            List<Employee> employees = Files.lines(Paths.get(fileName))
                    .map(line -> line.split(","))
                    .map(parts -> {
                        try {
                            Integer id = Integer.parseInt(parts[0]);
                            String firstName = parts[1];
                            String lastName = parts[2];
                            String email = parts[3];
                            String phoneNumber = parts[4];
                            Date hireDate = new SimpleDateFormat("yyyy-MM-dd").parse(parts[5]);
                            String jobTitle = parts[6];
                            String department = parts[7];
                            BigDecimal salary = new BigDecimal(parts[8]);
                            Integer managerId = Integer.parseInt(parts[9]);

                            return new Employee(id, firstName, lastName, email, phoneNumber, hireDate, jobTitle, department, salary, managerId);
                        } catch (ParseException | NumberFormatException e) {
                            e.printStackTrace();
                            return null;
                        }
                    })
                    .filter(employee -> employee != null)
                    .collect(Collectors.toList());

            // Serialize the list of employees
            try (FileOutputStream fos = new FileOutputStream("employees.ser");
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(employees);
            }
            // Print the list of employees
            employees.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

In this example, we use `Files.lines(Paths.get(fileName))` to read the lines of the file into a stream. We then use `map()` to split each line into parts and map those parts to `Employee` objects. The `filter()` method is used to remove any `null` values that may occur during parsing. Finally, we collect the `Employee` objects into a list using `Collectors.toList()`. Note that the serialization step is omitted for brevity.