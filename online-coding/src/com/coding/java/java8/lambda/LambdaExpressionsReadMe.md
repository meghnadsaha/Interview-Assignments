### Lambda expressions

Lambda expressions are a key feature introduced in Java 8 to provide functional programming capabilities. Here are some common interview questions related to lambda expressions:


Using lambda expressions in Java provides several benefits, especially when working with collections and functional interfaces. Some of the main benefits include:

1. **Conciseness:** Lambda expressions allow you to write more concise code by reducing boilerplate code. This makes your code easier to read and maintain.
   Sure, here's a simple example demonstrating the conciseness of code using lambda expressions. Suppose you have a list of strings and you want to convert them all to uppercase:

Without lambda expressions:
```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("banana");
        strings.add("cherry");

        List<String> uppercaseStrings = new ArrayList<>();
        for (String str : strings) {
            uppercaseStrings.add(str.toUpperCase());
        }

        for (String str : uppercaseStrings) {
            System.out.println(str);
        }
    }
}
```

With lambda expressions:
```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("banana");
        strings.add("cherry");

        strings.stream()
               .map(String::toUpperCase)
               .forEach(System.out::println);
    }
}
```

In the lambda expression `String::toUpperCase`, `String::toUpperCase` is a method reference that is equivalent to the lambda expression `(str) -> str.toUpperCase()`. Using lambda expressions with the `map` and `forEach` methods of the stream API makes the code more concise and readable.
2. **Readability:** Lambda expressions can make your code more readable by expressing the behavior of a function in a more declarative way.

3. **Flexibility:** Lambda expressions allow you to pass behavior as an argument to methods, making your code more flexible and adaptable to different use cases.

Sure, here's another example demonstrating the flexibility of lambda expressions in Java. Suppose you have a list of names and you want to filter out names that start with a specific letter:

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        char startLetter = 'C';

        Predicate<String> startsWithLetter = name -> name.charAt(0) == startLetter;

        List<String> filteredNames = filterNames(names, startsWithLetter);

        System.out.println("Names starting with " + startLetter + ":");
        filteredNames.forEach(System.out::println);
    }

    private static List<String> filterNames(List<String> names, Predicate<String> condition) {
        List<String> filteredNames = new ArrayList<>();
        for (String name : names) {
            if (condition.test(name)) {
                filteredNames.add(name);
            }
        }
        return filteredNames;
    }
}
```

In this example, we use a lambda expression `name -> name.charAt(0) == startLetter` as a `Predicate` to filter out names that start with a specific letter (`startLetter`). The `filterNames` method takes a list of names and a `Predicate` implementation and filters out the names based on the given condition. This demonstrates how lambda expressions can be used to provide custom filtering logic based on a specific criterion.

4. **Functional Programming:** Lambda expressions enable functional programming features in Java, such as higher-order functions, which can lead to more modular and composable code.

5. **Parallelism:** Lambda expressions can simplify the process of writing parallel and concurrent code by allowing you to easily express operations that can be performed in parallel.

In Java, the `parallelStream()` method is used to create a parallel stream, which is a stream that can perform operations in parallel. Parallel streams leverage the power of multi-core processors to process elements of the stream concurrently, potentially improving the performance of operations on large datasets.

Here's a basic example demonstrating the use of `parallelStream()` to find the sum of numbers in a list:

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Sequential stream example
        long sequentialTime = measureTime(() -> {
            long sum = numbers.stream()
                              .mapToLong(i -> i)
                              .sum();
            System.out.println("Sequential sum: " + sum);
        });

        // Parallel stream example
        long parallelTime = measureTime(() -> {
            long sum = numbers.parallelStream()
                              .mapToLong(i -> i)
                              .sum();
            System.out.println("Parallel sum: " + sum);
        });

        System.out.println("Sequential time: " + sequentialTime + "ms");
        System.out.println("Parallel time: " + parallelTime + "ms");
    }

    private static long measureTime(Runnable action) {
        long startTime = System.currentTimeMillis();
        action.run();
        return System.currentTimeMillis() - startTime;
    }
}
```

In this example, we compare the performance of sequential and parallel streams for finding the sum of numbers in a list. The `parallelStream()` method is used to create a parallel stream for the parallel processing of elements. The actual performance improvement of parallel streams depends on the size of the data and the number of available processor cores.

6. **Code Reuse:** Lambda expressions can help you reuse code by defining behavior that can be applied to multiple contexts or collections.


Sure! Here's another example demonstrating code reuse through higher-order functions in Java. Suppose you have a list of strings representing names, and you want to filter out names that have a specific length and then convert them to uppercase:

```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // Reusable function to filter names by length
        Function<Integer, Predicate<String>> filterByLength = length -> name -> name.length() == length;

        // Reusable function to apply a function to each element in a list
        Function<List<String>, List<String>> applyFunctionToList = list -> list.stream()
                                                                                .map(String::toUpperCase)
                                                                                .collect(Collectors.toList());

        // Using the filterByLength function to filter names by length
        List<String> filteredNames = names.stream()
                                           .filter(filterByLength.apply(5))
                                           .collect(Collectors.toList());
        System.out.println("Filtered names: " + filteredNames);

        // Using the applyFunctionToList function to convert names to uppercase
        List<String> uppercaseNames = applyFunctionToList.apply(names);
        System.out.println("Uppercase names: " + uppercaseNames);
    }
}
```

In this example, we define a reusable function `filterByLength` that takes an integer length as an argument and returns a predicate that filters names based on their length. We also define a `applyFunctionToList` function that applies a given function (in this case, converting names to uppercase) to each element in a list. These higher-order functions allow us to write reusable and composable code for processing lists of names in different ways.


Overall, lambda expressions can improve the quality of your code by making it more concise, readable, and flexible, while also enabling functional programming features in Java.

1. **What is a lambda expression in Java?**
    - A lambda expression is a concise way to represent an anonymous function (a function without a name) that can be passed around and executed later.

2. **How are lambda expressions written in Java?**
    - Lambda expressions consist of parameters, an arrow `->`, and a body. For example: `(a, b) -> a + b`.

3. **What is the syntax for a lambda expression?**
    - `(parameters) -> expression` or `(parameters) -> { statements; }`.

4. **What are the main benefits of using lambda expressions?**
    - They enable functional programming features, such as passing behavior in methods more easily, making the code more concise and readable.
    - Here's a simple example to demonstrate the benefits of using lambda expressions in Java. Suppose you have a list of integers and you want to filter out the even numbers and then print them:

Without lambda expressions:
```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        List<Integer> evenNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }

        for (Integer evenNumber : evenNumbers) {
            System.out.println(evenNumber);
        }
    }
}
```

With lambda expressions:
```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        numbers.stream()
               .filter(number -> number % 2 == 0)
               .forEach(System.out::println);
    }
}
```

In this example, the lambda expression `number -> number % 2 == 0` is used as a predicate to filter out even numbers from the list. The code using lambda expressions is more concise and readable compared to the traditional approach using loops and conditionals.

5. **Can lambda expressions access variables from their enclosing scope?**
    - Yes, lambda expressions can access variables from their enclosing scope, but they must be effectively final (i.e., their value must not change after initialization).
      Here's another example demonstrating the use of lambda expressions accessing variables from their enclosing scope, this time using a `Consumer` to modify elements in a list:

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Lambda expression accessing a variable from the enclosing scope
        int factor = 10; // This variable is effectively final

        // Using a Consumer to modify elements in the list based on a factor
        Consumer<Integer> multiplyByFactor = num -> {
            num *= factor; // Accessing and modifying a variable from the enclosing scope
            System.out.println(num);
        };

        // Applying the Consumer to each element in the list
        numbers.forEach(multiplyByFactor);
    }
}
```

In this example, we define a `Consumer` lambda expression `multiplyByFactor` that multiplies each element in the list by a factor (`factor`) from the enclosing scope. The lambda expression accesses and modifies the `factor` variable, which is effectively final. This demonstrates how lambda expressions can be used to modify elements in a list based on variables from the enclosing scope.

6. **What is the functional interface?**
    - A functional interface is an interface with only one abstract method. Lambda expressions can be used to instantiate functional interfaces.

7. **What is the type of a lambda expression?**
    - The type of a lambda expression is determined by the context in which it is used or by the target type, which must be a functional interface.

   Here's another example demonstrating the use of lambda expressions accessing variables from their enclosing scope, this time using a `Consumer` to modify elements in a list:

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Lambda expression accessing a variable from the enclosing scope
        int factor = 10; // This variable is effectively final

        // Using a Consumer to modify elements in the list based on a factor
        Consumer<Integer> multiplyByFactor = num -> {
            num *= factor; // Accessing and modifying a variable from the enclosing scope
            System.out.println(num);
        };

        // Applying the Consumer to each element in the list
        numbers.forEach(multiplyByFactor);
    }
}
```

In this example, we define a `Consumer` lambda expression `multiplyByFactor` that multiplies each element in the list by a factor (`factor`) from the enclosing scope. The lambda expression accesses and modifies the `factor` variable, which is effectively final. This demonstrates how lambda expressions can be used to modify elements in a list based on variables from the enclosing scope.

8. **Can lambda expressions throw exceptions?**
    - Yes, lambda expressions can throw exceptions, but the exceptions must be compatible with the functional interface's abstract method.

Yes, lambda expressions in Java can throw exceptions, but there are some restrictions. Specifically, if a lambda expression's body throws a checked exception, the functional interface used by the lambda expression must declare that exception in its method signature using the `throws` clause. Here's an example:

```java
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // Lambda expression that throws an exception
        Function<Integer, Integer> divideByZero = num -> {
            if (num == 0) {
                throw new IllegalArgumentException("Cannot divide by zero");
            }
            return 10 / num;
        };

        try {
            // Calling the lambda expression
            int result = divideByZero.apply(0);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
```

In this example, the lambda expression `divideByZero` throws an `IllegalArgumentException` if the input value is zero. The `Function` functional interface used by the lambda expression declares that it may throw an exception by including `throws Exception` in its method signature. The exception is caught and handled in the `main` method's `try-catch` block.


Here's another example demonstrating a lambda expression that throws a custom checked exception:

```java
import java.util.function.Consumer;

// Custom checked exception
class CustomCheckedException extends Exception {
    public CustomCheckedException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        // Lambda expression that throws a custom checked exception
        Consumer<String> printWithException = str -> {
            if (str == null) {
                try {
                    throw new CustomCheckedException("Input string is null");
                } catch (CustomCheckedException e) {
                    System.out.println("Caught custom exception: " + e.getMessage());
                }
            } else {
                System.out.println(str);
            }
        };

        // Calling the lambda expression
        printWithException.accept(null);
        printWithException.accept("Hello, Lambda!");
    }
}
```

In this example, the lambda expression `printWithException` checks if the input string is `null` and throws a `CustomCheckedException` if it is. The `CustomCheckedException` is a custom checked exception that extends `Exception`. The lambda expression catches the `CustomCheckedException` and prints a message. When the lambda expression is called with a non-null string, it simply prints the string.


9. **How are lambda expressions used with collections?**
    - Lambda expressions can be used with the `Stream` API to perform operations on collections, such as filtering, mapping, and reducing elements.


Lambda expressions are commonly used with collections in Java to perform operations such as iteration, filtering, mapping, and reducing elements. They allow for a more concise and expressive way to work with collections compared to traditional approaches using loops and anonymous classes. Here's an example demonstrating various uses of lambda expressions with collections:

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Iterating over elements using forEach
        System.out.println("Iterating over elements:");
        numbers.forEach(System.out::println);

        // Filtering even numbers
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(num -> num % 2 == 0)
                                           .collect(Collectors.toList());
        System.out.println("\nEven numbers: " + evenNumbers);

        // Mapping each number to its square
        List<Integer> squaredNumbers = numbers.stream()
                                               .map(num -> num * num)
                                               .collect(Collectors.toList());
        System.out.println("\nSquared numbers: " + squaredNumbers);

        // Reducing the list to the sum of all numbers
        int sum = numbers.stream()
                         .reduce(0, Integer::sum);
        System.out.println("\nSum of numbers: " + sum);
    }
}
```

In this example, we first create a list of integers (`numbers`). We then use lambda expressions with Java's Stream API to perform the following operations:

1. Iterating over elements using `forEach`.
2. Filtering even numbers using `filter`.
3. Mapping each number to its square using `map`.
4. Reducing the list to the sum of all numbers using `reduce`.

Lambda expressions make it easier to work with collections by providing a more functional and expressive way to perform common operations.
10. **Can lambda expressions replace anonymous classes?**
    - Yes, lambda expressions can replace instances of anonymous classes in many cases, especially when the anonymous class implements a functional interface.

An anonymous class in Java is a class without a name that is defined and instantiated at the same time. It is typically used to quickly create a one-off class that implements an interface or extends a class. Anonymous classes are often used in situations where a class is needed to provide a specific implementation for a single-use scenario, such as event handling or callbacks.

Here's a basic example of an anonymous class implementing the `Runnable` interface:

```java
public class Main {
    public static void main(String[] args) {
        // Using an anonymous class to create a new thread
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from anonymous class!");
            }
        });
        thread.start();
    }
}
```

In this example, the anonymous class implements the `Runnable` interface and provides an implementation for the `run` method. An instance of this anonymous class is then passed to the `Thread` constructor to create a new thread that executes the `run` method when started.

Anonymous classes can be useful for short, one-off implementations, but they can make the code harder to read and maintain if used extensively. Lambda expressions provide a more concise and readable alternative in many cases, especially when implementing functional interfaces.
These questions should give you a good understanding of lambda expressions in Java and how they are used in practice.


Here are 200 coding questions that can be solved using lambda expressions in Java:

Here are the answers to the first 10 coding questions:

1. Find the sum of all elements in a list.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   int sum = numbers.stream().mapToInt(Integer::intValue).sum();
   ```

2. Find the maximum element in a list.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   int max = numbers.stream().mapToInt(Integer::intValue).max().orElse(0);
   ```

3. Find the minimum element in a list.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   int min = numbers.stream().mapToInt(Integer::intValue).min().orElse(0);
   ```

4. Find the average of all elements in a list.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
   ```

5. Count the number of elements in a list.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   long count = numbers.stream().count();
   ```

6. Check if a list is empty.
   ```java
   List<Integer> numbers = Arrays.asList();
   boolean isEmpty = numbers.isEmpty();
   ```

7. Check if a list contains a specific element.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   boolean contains = numbers.contains(3);
   ```

8. Remove duplicates from a list.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 4, 5, 5);
   List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
   ```

9. Sort a list of integers in ascending order.
   ```java
   List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
   List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
   ```

10. Sort a list of strings in alphabetical order.
    ```java
    List<String> strings = Arrays.asList("banana", "apple", "orange", "grape");
    List<String> sortedStrings = strings.stream().sorted().collect(Collectors.toList());
    ```
Here are the answers to the next set of coding questions:

11. Filter even numbers from a list.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
   List<Integer> evenNumbers = numbers.stream()
                                       .filter(n -> n % 2 == 0)
                                       .collect(Collectors.toList());
   ```

12. Filter strings that start with a specific letter from a list.
   ```java
   List<String> strings = Arrays.asList("apple", "banana", "orange", "grape");
   char startLetter = 'a';
   List<String> filteredStrings = strings.stream()
                                         .filter(s -> s.startsWith(String.valueOf(startLetter)))
                                         .collect(Collectors.toList());
   ```

13. Find the square of each element in a list.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   List<Integer> squares = numbers.stream()
                                  .map(n -> n * n)
                                  .collect(Collectors.toList());
   ```

14. Convert all strings in a list to uppercase.
   ```java
   List<String> strings = Arrays.asList("apple", "banana", "orange", "grape");
   List<String> uppercaseStrings = strings.stream()
                                          .map(String::toUpperCase)
                                          .collect(Collectors.toList());
   ```

15. Concatenate all strings in a list.
   ```java
   List<String> strings = Arrays.asList("apple", "banana", "orange", "grape");
   String concatenatedString = strings.stream()
                                      .reduce("", (a, b) -> a + b);
   ```

16. Remove all whitespace from strings in a list.
   ```java
   List<String> strings = Arrays.asList("  apple  ", " banana ", "orange ", " grape");
   List<String> trimmedStrings = strings.stream()
                                        .map(String::trim)
                                        .collect(Collectors.toList());
   ```

17. Convert a list of strings to a list of integers.
   ```java
   List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
   List<Integer> integers = strings.stream()
                                   .map(Integer::parseInt)
                                   .collect(Collectors.toList());
   ```

18. Find the index of a specific element in a list.
   ```java
   List<String> strings = Arrays.asList("apple", "banana", "orange", "grape");
   String target = "orange";
   int index = IntStream.range(0, strings.size())
                        .filter(i -> strings.get(i).equals(target))
                        .findFirst()
                        .orElse(-1);
   ```

19. Replace all occurrences of a specific element in a list.
   ```java
   List<String> strings = Arrays.asList("apple", "banana", "orange", "grape");
   String oldString = "orange";
   String newString = "kiwi";
   List<String> replacedStrings = strings.stream()
                                         .map(s -> s.equals(oldString) ? newString : s)
                                         .collect(Collectors.toList());
   ```

20. Find the first element in a list.
   ```java
   List<String> strings = Arrays.asList("apple", "banana", "orange", "grape");
   String firstElement = strings.stream()
                                .findFirst() // first element
                        //      .reduce((first, second) -> second) last element
                                .orElse(null);
   ```

Here are the answers to the next set of coding questions:

22. Check if all elements in a list satisfy a condition.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   boolean allEven = numbers.stream().allMatch(n -> n % 2 == 0);
   ```

23. Check if any element in a list satisfies a condition.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   boolean anyEven = numbers.stream().anyMatch(n -> n % 2 == 0);
   ```

24. Merge two lists into a single list.
   ```java
   List<Integer> list1 = Arrays.asList(1, 2, 3);
   List<Integer> list2 = Arrays.asList(4, 5, 6);
   List<Integer> mergedList = Stream.concat(list1.stream(), list2.stream())
                                     .collect(Collectors.toList());
   ```

25. Split a list into multiple sublists.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
   int partitionSize = 3;
   List<List<Integer>> sublists = IntStream.range(0, numbers.size())
                                            .boxed()
                                            .collect(Collectors.groupingBy(index -> index / partitionSize))
                                            .values()
                                            .stream()
                                            .map(indices -> indices.stream()
                                                                   .map(numbers::get)
                                                                   .collect(Collectors.toList()))
                                            .collect(Collectors.toList());
  
    Output :   [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10]] 
   ```

26. Reverse a list.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   List<Integer> reversedNumbers = new ArrayList<>(numbers);
   Collections.reverse(reversedNumbers);
   ```

27. Perform a custom operation on each element in a list.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   List<Integer> squaredNumbers = numbers.stream()
                                         .map(n -> n * n)
                                         .collect(Collectors.toList());
   ```

28. Find the longest string in a list.
   ```java
   List<String> strings = Arrays.asList("apple", "banana", "orange", "grape");
   String longestString = strings.stream()
                                 .max(Comparator.comparing(String::length))
                                 .orElse(null);
   ```

29. Find the shortest string in a list.
   ```java
   List<String> strings = Arrays.asList("apple", "banana", "orange", "grape");
   String shortestString = strings.stream()
                                  .min(Comparator.comparing(String::length))
                                  .orElse(null);
   ```

30. Check if a list contains only unique elements.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   boolean hasDuplicates = numbers.size() != numbers.stream().distinct().count();
   ```

31. Check if a list is sorted in ascending order.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   boolean isSorted = IntStream.range(0, numbers.size() - 1)
                                .allMatch(i -> numbers.get(i) <= numbers.get(i + 1));
   ```

32. Check if a list is sorted in descending order.
   ```java
   List<Integer> numbers = Arrays.asList(5, 4, 3, 2, 1);
   boolean isSortedDescending = IntStream.range(0, numbers.size() - 1)
                                         .allMatch(i -> numbers.get(i) >= numbers.get(i + 1));
   ```

33. Find the second largest element in a list.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   Optional<Integer> secondLargest = numbers.stream()
                                            .sorted(Comparator.reverseOrder())
                                            .skip(1)
                                            .findFirst();
   ```

34. Find the second smallest element in a list.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   Optional<Integer> secondSmallest = numbers.stream()
                                              .sorted()
                                              .skip(1)
                                              .findFirst();
   ```

35. Remove all elements from a list that satisfy a condition.
   ```java
   List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
   numbers.removeIf(n -> n % 2 == 0);
   ```

36. Partition a list into two lists based on a condition.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   Map<Boolean, List<Integer>> partitionedNumbers = numbers.stream()
                                                            .collect(Collectors.partitioningBy(n -> n % 2 == 0));
   
   Output :   [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10]] {false=[1, 3, 5], true=[2, 4]}
   ```

37. Group elements in a list by a specific criteria.
   ```java
   List<String> strings = Arrays.asList("apple", "banana", "orange", "grape");
   Map<Integer, List<String>> groupedByLength = strings.stream()
                                                       .collect(Collectors.groupingBy(String::length));
   ```

38. Find the average length of strings in a list.
   ```java
   List<String> strings = Arrays.asList("apple", "banana", "orange", "grape");
   double averageLength = strings.stream()
                                 .mapToInt(String::length)
                                 .average()
                                 .orElse(0);
   ```

39. Find the sum of squares of all elements in a list.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   int sumOfSquares = numbers.stream()
                             .mapToInt(n -> n * n)
                             .sum();
   ```

40. Find the product of all elements in a list.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   int product = numbers.stream()
                        .reduce(1, (a, b) -> a * b);
   ```

Here are the solutions to the problems using streams in Java:

1. Find the factorial of a number using streams.
```java
int number = 5;
int factorial = IntStream.rangeClosed(1, number)
                        .reduce(1, (a, b) -> a * b);
```

2. Find the power of a number using streams.
```java
int base = 2;
int exponent = 3;
int power = IntStream.rangeClosed(1, exponent)
                     .reduce(1, (a, b) -> a * base);
```

3. Find the nth Fibonacci number using streams.
```java
int n = 7;
int fibonacci = Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
                      .limit(n)
                      .reduce((a, b) -> b)
                      .map(f -> f[0])
                      .orElse(0);
```

4. Generate a list of prime numbers up to a given number.
```java
int limit = 20;
List<Integer> primes = IntStream.rangeClosed(2, limit)
                                .filter(num -> IntStream.range(2, (int) Math.sqrt(num) + 1).allMatch(i -> num % i != 0))
                                .boxed()
                                .collect(Collectors.toList());
```

5. Check if a number is prime using streams.
```java
int number = 17;
boolean isPrime = number > 1 && IntStream.range(2, (int) Math.sqrt(number) + 1).noneMatch(i -> number % i == 0);
```

6. Find the factors of a number using streams.
```java
int number = 12;
List<Integer> factors = IntStream.rangeClosed(1, number)
                                  .filter(i -> number % i == 0)
                                  .boxed()
                                  .collect(Collectors.toList());
```

7. Check if two lists are equal using streams.
```java
List<Integer> list1 = Arrays.asList(1, 2, 3);
List<Integer> list2 = Arrays.asList(1, 2, 3);
boolean areEqual = Objects.equals(list1, list2);
```

8. Find the intersection of two lists using streams.
```java
List<Integer> list1 = Arrays.asList(1, 2, 3);
List<Integer> list2 = Arrays.asList(2, 3, 4);
List<Integer> intersection = list1.stream()
                                  .filter(list2::contains)
                                  .collect(Collectors.toList());
```

9. Find the union of two lists using streams.
```java
List<Integer> list1 = Arrays.asList(1, 2, 3);
List<Integer> list2 = Arrays.asList(2, 3, 4);
List<Integer> union = Stream.concat(list1.stream(), list2.stream())
                            .distinct()
                            .collect(Collectors.toList());
```

10. Find the difference of two lists using streams.
```java
List<Integer> list1 = Arrays.asList(1, 2, 3);
List<Integer> list2 = Arrays.asList(2, 3, 4);
List<Integer> difference = list1.stream()
                                .filter(num -> !list2.contains(num))
                                .collect(Collectors.toList());
```

11. Find the symmetric difference of two lists using streams.
```java
List<Integer> list1 = Arrays.asList(1, 2, 3);
List<Integer> list2 = Arrays.asList(2, 3, 4);
List<Integer> symmetricDifference = Stream.concat(
        list1.stream().filter(num -> !list2.contains(num)),
        list2.stream().filter(num -> !list1.contains(num)))
        .collect(Collectors.toList());

Output : [1, 4]
```

52. Check if a list is a subset of another list using streams.
```java
List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> list2 = Arrays.asList(2, 3);
boolean isSubset = list2.stream().allMatch(list1::contains);
```

53. Check if a list is a superset of another list using streams.
```java
List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> list2 = Arrays.asList(2, 3);
boolean isSuperset = list1.stream().allMatch(list2::contains);
```

54. Find the common elements in multiple lists using streams.
```java
List<Integer> list1 = Arrays.asList(1, 2, 3);
List<Integer> list2 = Arrays.asList(2, 3, 4);
List<Integer> list3 = Arrays.asList(3, 4, 5);
List<Integer> commonElements = Stream.of(list1, list2, list3)
                                      .flatMap(Collection::stream)
                                      .distinct()
                                      .filter(num -> Stream.of(list1, list2, list3).allMatch(list -> list.contains(num)))
                                      .collect(Collectors.toList());
```

55. Find the distinct elements in multiple lists using streams.
```java
List<Integer> list1 = Arrays.asList(1, 2, 3);
List<Integer> list2 = Arrays.asList(2, 3, 4);
List<Integer> list3 = Arrays.asList(3, 4, 5);
List<Integer> distinctElements = Stream.of(list1, list2, list3)
                                        .flatMap(Collection::stream)
                                        .distinct()
                                        .collect(Collectors.toList());
```

56. Find the maximum element in a list of lists using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
Optional<Integer> maxElement = listOfLists.stream()
                                           .flatMap(Collection::stream)
                                           .max(Integer::compareTo);
```

57. Find the minimum element in a list of lists using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
Optional<Integer> minElement = listOfLists.stream()
                                           .flatMap(Collection::stream)
                                           .min(Integer::compareTo);
```

58. Find the sum of all elements in a list of lists using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
int sum = listOfLists.stream()
                     .flatMapToInt(list -> list.stream().mapToInt(Integer::intValue))
                     .sum();
```

59. Find the average of all elements in a list of lists using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
double average = listOfLists.stream()
                            .flatMapToInt(list -> list.stream().mapToInt(Integer::intValue))
                            .average()
                            .orElse(0.0);
```

60. Flatten a list of lists into a single list using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
List<Integer> flattenedList = listOfLists.stream()
                                         .flatMap(Collection::stream)
                                         .collect(Collectors.toList());
```

61. Concatenate all strings in a list of lists using streams.
```java
List<List<String>> listOfLists = Arrays.asList(Arrays.asList("hello", "world"), Arrays.asList("foo", "bar"), Arrays.asList("baz", "qux"));
String concatenatedString = listOfLists.stream()
                                       .flatMap(Collection::stream)
                                       .collect(Collectors.joining());
```

62. Remove duplicates from a list of lists using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 4), Arrays.asList(3, 4, 5));
List<Integer> distinctList = listOfLists.stream()
                                        .flatMap(Collection::stream)
                                        .distinct()
                                        .collect(Collectors.toList());
```
Here are the solutions to the remaining problems using streams in Java:

63. Sort a list of lists of integers in ascending order using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(3, 2, 1), Arrays.asList(6, 5, 4), Arrays.asList(9, 8, 7));
List<List<Integer>> sortedLists = listOfLists.stream()
                                            .map(list -> list.stream().sorted().collect(Collectors.toList()))
                                            .collect(Collectors.toList());
```

64. Sort a list of lists of strings in alphabetical order using streams.
```java
List<List<String>> listOfLists = Arrays.asList(Arrays.asList("b", "a", "c"), Arrays.asList("f", "e", "d"), Arrays.asList("i", "h", "g"));
List<List<String>> sortedLists = listOfLists.stream()
                                            .map(list -> list.stream().sorted().collect(Collectors.toList()))
                                            .collect(Collectors.toList());
```

65. Filter even numbers from a list of lists using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
List<Integer> evenNumbers = listOfLists.stream()
                                       .flatMap(Collection::stream)
                                       .filter(num -> num % 2 == 0)
                                       .collect(Collectors.toList());
```

66. Filter strings that start with a specific letter from a list of lists using streams.
```java
List<List<String>> listOfLists = Arrays.asList(Arrays.asList("apple", "banana", "cherry"), Arrays.asList("orange", "pear", "grape"), Arrays.asList("kiwi", "melon", "papaya"));
List<String> filteredStrings = listOfLists.stream()
                                          .flatMap(Collection::stream)
                                          .filter(str -> str.startsWith("p"))
                                          .collect(Collectors.toList());
```

67. Find the square of each element in a list of lists using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
List<List<Integer>> squaredLists = listOfLists.stream()
                                              .map(list -> list.stream().map(num -> num * num).collect(Collectors.toList()))
                                              .collect(Collectors.toList());
```

68. Convert all strings in a list of lists to uppercase using streams.
```java
List<List<String>> listOfLists = Arrays.asList(Arrays.asList("hello", "world"), Arrays.asList("foo", "bar"), Arrays.asList("baz", "qux"));
List<List<String>> upperCaseLists = listOfLists.stream()
                                               .map(list -> list.stream().map(String::toUpperCase).collect(Collectors.toList()))
                                               .collect(Collectors.toList());
```

69. Remove all whitespace from strings in a list of lists using streams.
```java
List<List<String>> listOfLists = Arrays.asList(Arrays.asList("hello world", "foo bar"), Arrays.asList("baz qux", "quux quuz"));
List<List<String>> noWhitespaceLists = listOfLists.stream()
                                                  .map(list -> list.stream().map(str -> str.replaceAll("\\s", "")).collect(Collectors.toList()))
                                                  .collect(Collectors.toList());
```

70. Convert a list of lists of strings to a list of lists of integers using streams.
```java
List<List<String>> listOfLists = Arrays.asList(Arrays.asList("1", "2", "3"), Arrays.asList("4", "5", "6"), Arrays.asList("7", "8", "9"));
List<List<Integer>> listOfIntegers = listOfLists.stream()
                                                .map(list -> list.stream().map(Integer::parseInt).collect(Collectors.toList()))
                                                .collect(Collectors.toList());
```

71. Find the index of a specific element in a list of lists using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
int elementToFind = 5;
OptionalInt index = IntStream.range(0, listOfLists.size())
                             .filter(i -> listOfLists.get(i).contains(elementToFind))
                             .findFirst();
```

72. Replace all occurrences of a specific element in a list of lists using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
int elementToReplace = 5;
int replacement = 10;
List<List<Integer>> replacedLists = listOfLists.stream()
                                              .map(list -> list.stream().map(num -> num == elementToReplace ? replacement : num).collect(Collectors.toList()))
                                              .collect(Collectors.toList());
```

73. Find the first element in a list of lists using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
Optional<Integer> firstElement = listOfLists.stream()
                                            .flatMap(List::stream)
                                            .findFirst();
```

74. Find the last element in a list of lists using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
Optional<Integer> lastElement = listOfLists.stream()
                                           .flatMap(List::stream)
                                           .reduce((first, second) -> second);
```

Here are the solutions to the remaining problems using streams in Java:

75. Check if all elements in a list of lists satisfy a condition using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
boolean allEven = listOfLists.stream()
                             .flatMap(List::stream)
                             .allMatch(num -> num % 2 == 0);
```

76. Check if any element in a list of lists satisfies a condition using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
boolean anyEven = listOfLists.stream()
                             .flatMap(List::stream)
                             .anyMatch(num -> num % 2 == 0);
```

77. Merge two lists of lists into a single list of lists using streams.
```java
List<List<Integer>> list1 = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
List<List<Integer>> list2 = Arrays.asList(Arrays.asList(5, 6), Arrays.asList(7, 8));
List<List<Integer>> mergedList = Stream.concat(list1.stream(), list2.stream())
                                       .collect(Collectors.toList());
```

78. Split a list of lists into multiple sublists using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
List<List<Integer>> subLists = listOfLists.stream()
                                          .map(list -> list.subList(0, list.size() / 2))
                                          .collect(Collectors.toList());
```

79. Reverse a list of lists using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
List<List<Integer>> reversedLists = listOfLists.stream()
                                               .map(list -> new ArrayList<>(list))
                                               .map(list -> {Collections.reverse(list); return list;})
                                               .collect(Collectors.toList());
```

80. Perform a custom operation on each element in a list of lists using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
List<List<Integer>> customOperationLists = listOfLists.stream()
                                                      .map(list -> list.stream().map(num -> num * 2).collect(Collectors.toList()))
                                                      .collect(Collectors.toList());
```

81. Find the longest string in a list of lists using streams.
```java
List<List<String>> listOfLists = Arrays.asList(Arrays.asList("apple", "banana", "cherry"), Arrays.asList("orange", "pear"), Arrays.asList("kiwi", "melon", "papaya"));
Optional<String> longestString = listOfLists.stream()
                                            .flatMap(List::stream)
                                            .max(Comparator.comparingInt(String::length));
```

82. Find the shortest string in a list of lists using streams.
```java
List<List<String>> listOfLists = Arrays.asList(Arrays.asList("apple", "banana", "cherry"), Arrays.asList("orange", "pear"), Arrays.asList("kiwi", "melon", "papaya"));
Optional<String> shortestString = listOfLists.stream()
                                             .flatMap(List::stream)
                                             .min(Comparator.comparingInt(String::length));
```

83. Check if a list of lists contains only unique elements using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
boolean allUnique = listOfLists.stream()
                               .flatMap(List::stream)
                               .collect(Collectors.toSet())
                               .size() == listOfLists.stream()
                                                     .flatMap(List::stream)
                                                     .count();
```

84. Check if a list of lists is sorted in ascending order using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
boolean isSorted = listOfLists.stream()
                             .allMatch(list -> list.equals(list.stream().sorted().collect(Collectors.toList())));
```

85. Check if a list of lists is sorted in descending order using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(9, 8, 7), Arrays.asList(6, 5, 4), Arrays.asList(3, 2, 1));
boolean isSorted = listOfLists.stream()
                             .allMatch(list -> list.equals(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())));
```

86. Find the second largest element in a list of lists using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
int secondLargest = listOfLists.stream()
                               .flatMapToInt(list -> list.stream().mapToInt(Integer::intValue))
                               .distinct()
                               .sorted()
                               .skip(Math.max(0, listOfLists.stream().flatMapToInt(list -> list.stream().mapToInt(Integer::intValue)).distinct().count() - 2))
                               .findFirst()
                               .orElseThrow(() -> new IllegalArgumentException("List is empty or has only one element"));
```

87. Find the second smallest element in a list of lists using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
int secondSmallest = listOfLists.stream()
                                .flatMapToInt(list -> list.stream().mapToInt(Integer::intValue))
                                .distinct()
                                .sorted()
                                .skip(1)
                                .findFirst()
                                .orElseThrow(() -> new IllegalArgumentException("List is empty or has only one element"));
```

88. Remove all elements from a list of lists that satisfy a condition using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
List<List<Integer>> filteredList = listOfLists.stream()
                                               .map(list -> list.stream().filter(num -> num % 2 == 0).collect(Collectors.toList()))
                                               .collect(Collectors.toList());
```

89. Partition a list of lists into two lists based on a condition using streams.
```java
        Map<Boolean, List<List<Integer>>> partitionedLists = listOfLists.stream()
        .collect(Collectors.partitioningBy(list -> list.stream().mapToInt(Integer::intValue).sum() % 2 == 0));

        List<List<Integer>> evenSumLists = partitionedLists.get(true);
        List<List<Integer>> oddSumLists = partitionedLists.get(false);

        System.out.println("Lists with even sum of elements:");
        evenSumLists.forEach(System.out::println);

        System.out.println("Lists with odd sum of elements:");
        oddSumLists.forEach(System.out::println);

```

90. Group elements in a list of lists by a specific criteria using streams.
```java
 List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9),
                Arrays.asList(10, 11, 12)
        );

        Map<Boolean, List<List<Integer>>> groupedLists = listOfLists.stream()
                                                                    .collect(Collectors.groupingBy(
                                                                            list -> list.stream().mapToInt(Integer::intValue).sum() % 2 == 0
                                                                    ));

        System.out.println("Lists with even sum of elements:");
        groupedLists.get(true).forEach(System.out::println);

        System.out.println("Lists with odd sum of elements:");
        groupedLists.get(false).forEach(System.out::println);
```

91. Find the average length of strings in a list of lists using streams.
```java
 List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana", "cherry"),
                Arrays.asList("orange", "pear"),
                Arrays.asList("kiwi", "melon", "papaya")
        );

        double averageLength = listOfLists.stream()
                                          .flatMap(List::stream) // Flatten the list of lists into a single stream of strings
                                          .mapToInt(String::length) // Map each string to its length
                                          .average() // Calculate the average
//                                          .orElse(0) // Return 0 if the list is empty
                                          .orElseThrow(() -> new IllegalArgumentException("List is empty"));


        System.out.println("Average length of strings: " + averageLength);
```

92. Find the sum of squares of all elements in a list of lists using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
int sumOfSquares = listOfLists.stream()
                              .flatMapToInt(list -> list.stream().mapToInt(num -> num * num))
                              .sum();
```

93. Find the product of all elements in a list of lists using streams.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
Optional<Integer> product = listOfLists.stream()
                                       .flatMap(List::stream)
                                       .reduce((num1, num2) -> num1 * num2);
```

94. Find the factorial of a number using streams in a list of lists.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
List<Integer> factorials = listOfLists.stream()
                                     .flatMap(List::stream)
                                     .map(num -> IntStream.rangeClosed(1, num).reduce(1, (x, y) -> x * y))
                                     .collect(Collectors.toList());
```

95. Find the power of a number using streams in a list of lists.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
List<Integer> powers = listOfLists.stream()
                                  .flatMap(List::stream)
                                  .map(num -> (int) Math.pow(num, 2))
                                  .collect(Collectors.toList());
```

96. Find the nth Fibonacci number using streams in a list of lists.
```java
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
int n = 5; // Example value of n
List<Integer> fibonacciNumbers = listOfLists.stream()
                                            .flatMap(List::stream)
                                            .map(num -> {
                                                int a = 0, b = 1;
                                                for (int i = 0; i < num; i++) {
                                                    int temp = a;
                                                    a = b;
                                                    b = temp + b;
                                                }
                                                return a;
                                            })
                                            .collect(Collectors.toList());
```
```java

        List<List<Integer>> listOfLists = Arrays.asList(
            Arrays.asList(2, 3, 5, 7, 11, 13),
            Arrays.asList(17, 19, 23, 29),
            Arrays.asList(31, 37, 41)
        );

        // 97. Generate a list of prime numbers up to a given number in a list of lists
        List<Integer> primeNumbers = listOfLists.stream()
            .flatMap(List::stream)
            .filter(Main::isPrime)
            .collect(Collectors.toList());
        System.out.println("Prime numbers: " + primeNumbers);

        // 98. Check if a number is prime using streams in a list of lists
        boolean isPrime = listOfLists.stream()
            .flatMap(List::stream)
            .anyMatch(Main::isPrime);
        System.out.println("Is prime number present: " + isPrime);

        // 99. Find the factors of a number using streams in a list of lists
                
        List<List<Integer>> factors = listOfLists.stream()
            .flatMap(List::stream)
            .map(Main::findFactors)
            .collect(Collectors.toList());
        System.out.println("Factors: " + factors);

        // Add more examples for the remaining questions here...
    }

    // Utility method to check if a number is prime
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Utility method to find factors of a number
    private static List<Integer> findFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }


```
Here are the solutions to the remaining problems using streams in Java:

97. Generate a list of prime numbers up to a given number in a list of lists.
```java
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        int n = 10; // Example value of n
        List<Integer> primes = IntStream.rangeClosed(2, n)
                                         .filter(num -> IntStream.rangeClosed(2, (int) Math.sqrt(num)).allMatch(i -> num % i != 0))
                                         .boxed()
                                         .collect(Collectors.toList());
        System.out.println("List of prime numbers up to " + n + ": " + primes);
    }
}
```

98. Check if a number is prime using streams in a list of lists.
```java
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        int num = 7; // Example number
        boolean isPrime = IntStream.rangeClosed(2, (int) Math.sqrt(num))
                                   .noneMatch(i -> num % i == 0);
        System.out.println(num + " is prime: " + isPrime);
    }
}
```

99. Find the factors of a number using streams in a list of lists.
```java
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        int num = 12; // Example number
        List<Integer> factors = IntStream.rangeClosed(1, num)
                                         .filter(i -> num % i == 0)
                                         .boxed()
                                         .collect(Collectors.toList());
        System.out.println("Factors of " + num + ": " + factors);
    }
}
```

100. Check if two lists of lists are equal using streams.
```java
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> list1 = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
        List<List<Integer>> list2 = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
        
        boolean isEqual = Objects.equals(list1, list2);
        System.out.println("Lists are equal: " + isEqual);
    }
}
```

101. Find the intersection of two lists of lists using streams.
```java
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> list1 = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
        List<List<Integer>> list2 = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 3));
        
        List<List<Integer>> intersection = list1.stream()
                                                .filter(list2::contains)
                                                .collect(Collectors.toList());
        System.out.println("Intersection of lists: " + intersection);
    }
}
```

