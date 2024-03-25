> Here are some interview questions related to method references in Java:

1. **What are method references in Java?**
    - Method references are a shorthand notation for lambda expressions to call methods by referring to their names directly.

2. **How many types of method references are there?**
    - There are four types of method references:
        - Reference to a static method
        - Reference to an instance method of a particular object
        - Reference to an instance method of an arbitrary object of a particular type
        - Reference to a constructor

3. **What is the syntax for method references?**
    - The syntax for method references is `Class::methodName` for static methods, `instance::methodName` for instance methods, and `Class::new` for constructors.

4. **How are method references different from lambdas?**
    - Method references provide a more concise syntax for calling methods, especially when the lambda expression simply calls an existing method without performing additional logic.

5. **Can you give an example of each type of method reference?**
    - Static method reference: `Math::max`
    - Instance method reference: `String::length`
    - Instance method of an arbitrary object reference: `String::toUpperCase`
    - Constructor reference: `ArrayList::new`

6. **When would you use method references instead of lambdas?**
    - Method references are useful when the lambda expression simply calls an existing method without any additional logic. They provide a more readable and concise way to achieve the same functionality.

7. **Can you use method references with functional interfaces?**
    - Yes, method references can be used wherever a functional interface is expected, as they provide a way to implement the single abstract method of the functional interface.

8. **How does Java determine which overloaded method to reference in a method reference?**
    - Java uses the context in which the method reference is used to determine the target method. It considers the functional interface's abstract method signature to match against the available overloaded methods.

9. **Can you create your own functional interface and use method references with it?**
    - Yes, you can create your own functional interface and use method references with it, as long as it has a single abstract method that can be implemented by a method reference.

10. **Can you use method references with streams in Java?**
    - Yes, method references can be used with streams in Java to perform operations on stream elements using existing methods.

These questions are designed to assess your understanding of method references in Java and how they can be used in different contexts.



> Here are ten coding questions related to method references in Java:

1. **Using Method Reference to Static Method**
   - Define a static method `isEven` that takes an integer and returns true if it is even, and false otherwise. Use a method reference to this static method to filter a list of integers to get only the even numbers.
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
List<Integer> evenNumbers = numbers.stream()
                                    .filter(MethodReferenceExample::isEven)
                                    .collect(Collectors.toList());
System.out.println(evenNumbers);

```
2. **Using Method Reference to Instance Method of a Particular Object**
   - Create a class `StringUtils` with an instance method `convertToUpperCase` that takes a string and returns its uppercase version. Create an instance of `StringUtils` and use a method reference to its `convertToUpperCase` method to convert a list of strings to uppercase.
```java
StringUtils stringUtils = new StringUtils();
List<String> strings = Arrays.asList("apple", "banana", "cherry");
List<String> upperCaseStrings = strings.stream()
                                       .map(stringUtils::convertToUpperCase)
                                       .collect(Collectors.toList());
System.out.println(upperCaseStrings);

```
3. **Using Method Reference to Instance Method of an Arbitrary Object of a Particular Type**
   - Define a class `Person` with an instance method `getName` that returns the person's name. Create a list of `Person` objects and use a method reference to `Person::getName` to extract the names into a new list.
```java
List<Person> persons = Arrays.asList(new Person("Alice"), new Person("Bob"), new Person("Charlie"));
List<String> names = persons.stream()
                            .map(Person::getName)
                            .collect(Collectors.toList());
System.out.println(names);

```
4. **Using Constructor Reference**
   - Define a functional interface `Converter` with a single method `convert` that takes a string and returns an integer. Use a constructor reference to `Integer::new` to implement the `convert` method that converts a string to an integer.
```java
Converter<String, Integer> converter = Integer::new;
Integer convertedValue = converter.convert("123");
System.out.println(convertedValue);

```
5. **Using Method Reference to Instance Method of an Arbitrary Object**
   - Define a functional interface `Calculator` with a single method `calculate` that takes two integers and returns an integer result. Implement this interface using a method reference to the `add` method of an `Arithmetic` class that has an `add` method to perform addition.
```java
    Calculator calculator = Arithmetic::add;
        int result = calculator.calculate(10, 20);
        System.out.println(result);

```
6. **Using Method Reference to Static Method with Parameter**
   - Define a functional interface `StringTransformer` with a single method `transform` that takes a string and a `Function<String, String>` as arguments and returns a transformed string. Implement this interface using a method reference to the `toUpperCase` method of the `String` class.
```java
StringTransformer transformer = String::toUpperCase;
String transformedString = transformer.transform("hello");
System.out.println(transformedString);

```
7. **Using Method Reference to Instance Method with Parameter**
   - Define a functional interface `TextFormatter` with a single method `format` that takes a string and a `Function<String, String>` as arguments and returns a formatted string. Implement this interface using a method reference to the `trim` method of the `String` class.
```java
TextFormatter formatter = String::trim;
String formattedString = formatter.format("  hello  ");
System.out.println(formattedString);

```
8. **Using Method Reference to Instance Method of an Object from a Particular Class**
   - Define a functional interface `Printer` with a single method `print` that takes a string and prints it. Implement this interface using a method reference to the `println` method of the `System.out` object.
```java
Printer printer = System.out::println;
        printer.print("Hello, world!");

```
9. **Using Method Reference to Instance Method of an Object from a Particular Class**
   - Define a functional interface `Multiplier` with a single method `multiply` that takes two integers and returns their product. Implement this interface using a method reference to the `multiply` method of the `Integer` class.
```java
Multiplier multiplier = Integer::multiply;
int product = multiplier.multiply(10, 20);
System.out.println(product);

```
10. **Using Method Reference to Instance Method of an Object from a Particular Class**
   - Define a functional interface `Predicate` with a single method `test` that takes an integer and returns a boolean. Implement this interface using a method reference to the `isEven` method of the `Integer` class.
```java
Predicate<Integer> isEvenPredicate = Integer::isEven;
boolean isEven = isEvenPredicate.test(10);
System.out.println(isEven);

```
These questions are designed to help you practice using method references in various scenarios and gain a deeper understanding of how they work in Java.