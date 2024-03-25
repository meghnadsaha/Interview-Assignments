Java 8 introduced several new features and enhancements to the language. Some of the key functionalities include:

1. **Lambda Expressions**: Lambda expressions provide a concise way to express instances of single-method interfaces (functional interfaces). They enable you to treat functionality as a method argument or create anonymous functions.

   ```java
   // Example of a lambda expression
   List<String> list = Arrays.asList("apple", "orange", "banana");
   list.forEach(s -> System.out.println(s));
   ```

2. **Functional Interfaces**: Functional interfaces are interfaces that have exactly one abstract method. They can have multiple default or static methods. Lambda expressions can be used to instantiate functional interfaces.

   ```java
   // Example of a functional interface
   @FunctionalInterface
   interface MyFunctionalInterface {
       void myMethod();
   }
   ```

3. **Stream API**: The Stream API allows for functional-style operations on streams of elements, such as filtering, mapping, reducing, and iterating. Streams do not store elements, and operations on streams are lazy, which can lead to more efficient processing.

   ```java
   // Example of using the Stream API
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   int sum = numbers.stream()
                   .filter(n -> n % 2 == 0)
                   .mapToInt(n -> n * 2)
                   .sum();
   ```

4. **Default Methods**: Default methods allow interfaces to have methods with implementation. This feature enables interfaces to evolve without breaking existing implementations.

   ```java
   // Example of a default method
   interface MyInterface {
       default void myMethod() {
           System.out.println("Default method");
       }
   }
   ```

5. **Optional**: Optional is a container object that may or may not contain a non-null value. It helps to avoid null pointer exceptions by providing methods for handling the presence or absence of a value.

   ```java
   // Example of using Optional
   Optional<String> optional = Optional.of("value");
   optional.ifPresent(value -> System.out.println("Value: " + value));
   ```

6. **Method References**: Method references provide a way to refer to methods without executing them. They can be used to point to constructors, static methods, or instance methods.

   ```java
   // Example of using method reference
   List<String> list = Arrays.asList("apple", "orange", "banana");
   list.forEach(System.out::println);
   ```

7. **Date and Time API**: Java 8 introduced a new Date and Time API in the `java.time` package to address the shortcomings of the existing `java.util.Date` and `java.util.Calendar` classes.

   ```java
   // Example of using the Date and Time API
   LocalDate date = LocalDate.now();
   LocalTime time = LocalTime.now();
   ```

These are just a few of the key features introduced in Java 8. The release also included other improvements, such as the new `java.util.function` package, the `CompletableFuture` class for asynchronous programming, and more.

`Predicate` and `Optional` are both functional interfaces in Java, but they serve different purposes.

1. **Predicate**:
   - Represents a predicate (boolean-valued function) of one argument.
   - Used for filtering or selecting elements based on a condition.
   - Commonly used with functional interfaces like `filter`, `removeIf`, `anyMatch`, `allMatch`, and `noneMatch` in streams.
   - Example: `Predicate<Integer> isEven = n -> n % 2 == 0;`

2. **Optional**:
   - Represents an object that may or may not contain a non-null value.
   - Used to avoid dealing with null values directly, reducing the chances of `NullPointerException`.
   - Provides methods like `isPresent`, `ifPresent`, `orElse`, `orElseGet`, and `orElseThrow` for working with the contained value or handling the absence of a value.
   - Example: `Optional<String> name = Optional.ofNullable(getName());`

In summary, `Predicate` is used for defining conditions for filtering elements, while `Optional` is used for handling nullable values in a more expressive way. They serve different purposes and are used in different contexts.