> Given an integer array, write a Java program using Java 8 Stream API to find all numbers that are repeated exactly n times in the array. Implement a method that takes an integer array and an integer n as input and returns a list of numbers that meet the criteria. Ensure that the method handles edge cases such as empty arrays or n being less than or equal to zero. Test your implementation with different input arrays to validate its correctness

To find all numbers that are repeated exactly `n` times in an integer array using Java 8 Stream API, you can use the `groupingBy` collector to group the elements by their occurrences and then filter the result to find the desired numbers. Here's an example:

```java
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 4, 4, 5, 6, 6};
        int n = 3;

        List<Integer> result = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == n)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Numbers repeated " + n + " times: " + result);
    }
}
```

In this example, we first convert the `int` array to a stream of `Integer` objects using `boxed()`. Then, we use the `groupingBy` collector to group the elements by their occurrences, counting how many times each element appears in the array. Next, we filter the map to find the entries that have the specified number of occurrences (`n`). Finally, we map the filtered entries to their keys (numbers) and collect them into a list (`result`).


> Here's a possible question related to checking balanced parentheses using Java 8 Stream API:

- Write a Java method that takes a string containing only parentheses as input and uses Java 8 Stream API to determine if the parentheses in the string are balanced. The method should return `true` if the parentheses are balanced and `false` otherwise. Use a stream operation to iterate over the characters of the input string and a `reduce` operation to keep track of the balance. Test your method with different input strings to validate its correctness.

- This question challenges the candidate to demonstrate their understanding of Java 8 Stream API operations (such as `reduce` and `split`) and their ability to use these operations to solve a common programming problem.

To check if a given parentheses expression is balanced or not using Java 8 Stream API, you can iterate over the characters of the expression and use a `reduce` operation to keep track of the balance. Here's how you can do it:

```java
import java.util.stream.Stream;

public class BalancedParentheses {

    public static void main(String[] args) {
        String expression1 = "((()))";
        String expression2 = "(()))(";

        System.out.println("Expression 1 is balanced: " + isBalanced(expression1));
        System.out.println("Expression 2 is balanced: " + isBalanced(expression2));
    }

    public static boolean isBalanced(String expression) {
        return Stream.of(expression.split(""))
                .reduce(0, (count, str) -> {
                    if (count < 0) {
                        return count; // Unbalanced
                    } else {
                        return str.equals("(") ? count + 1 : str.equals(")") ? count - 1 : count;
                    }
                }, Integer::sum) == 0;
    }
}
```

In this example, the `isBalanced` method splits the input string into individual characters using `split("")`, then uses a `reduce` operation to iterate over the characters. For each character, it checks if it's an opening parenthesis `'('` or a closing parenthesis `')'`, and updates the count accordingly. If the count ever goes negative, it means the expression is unbalanced (more closing parentheses than opening ones). Finally, the method returns `true` if the count is `0` (balanced) or `false` otherwise.

### Reflection in java

Reflection in Java is a powerful feature that allows you to inspect and manipulate classes, methods, fields, and other components of a Java program dynamically at runtime. It provides a way to examine or modify the behavior of classes, methods, and fields, even if they are private.

Here are some key aspects of reflection in Java:

1. **Accessing Class Information:** You can use reflection to get information about a class, such as its name, superclass, implemented interfaces, constructors, methods, and fields.

2. **Creating Instances:** Reflection allows you to create instances of classes dynamically, even if you don't know the exact class at compile time.

3. **Invoking Methods:** You can use reflection to invoke methods on objects dynamically, including private methods. This can be useful for scenarios where the method name or parameters are determined at runtime.

4. **Accessing and Modifying Fields:** Reflection enables you to access and modify fields of an object, including private fields, at runtime.

5. **Dynamic Proxy:** Reflection can be used to create dynamic proxy classes that implement a set of interfaces at runtime, enabling you to intercept method invocations and customize behavior.

While reflection can be a powerful tool, it should be used judiciously as it can make your code more complex and less readable. It can also have performance implications, as reflective operations are generally slower than their non-reflective counterparts.


Here's a simple example that demonstrates the use of reflection in Java:

```java
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {

    public static void main(String[] args) throws Exception {
        // Get the class object for the String class
        Class<?> stringClass = String.class;

        // Print the name of the class
        System.out.println("Class Name: " + stringClass.getName());

        // Get the list of methods in the String class
        System.out.println("Methods:");
        Method[] methods = stringClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        // Create an instance of the String class using reflection
        String str = (String) stringClass.getConstructor(String.class).newInstance("Hello, Reflection!");

        // Print the value of the string
        System.out.println("Value of str: " + str);

        // Get the field 'hash' from the String class
        Field field = String.class.getDeclaredField("hash");
        field.setAccessible(true); // Enable access to private field
        int hash = (int) field.get(str);

        // Print the value of the 'hash' field
        System.out.println("Value of hash field: " + hash);
    }
}
```
One of the key benefits of reflection in Java is its ability to provide flexibility and extensibility to your code by enabling you to inspect and manipulate classes, methods, and fields dynamically at runtime. Here's an example that demonstrates how reflection can be used to create a generic CSV (Comma-Separated Values) serializer that can work with different types of objects:

```java
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CsvSerializer {

    public static String serializeObject(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder csv = new StringBuilder();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(obj);
            csv.append(value).append(",");
        }

        return csv.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {
        List<Object> objects = new ArrayList<>();
        objects.add(new Person("John", 30));
        objects.add(new Car("Toyota", "Camry", 2010));

        for (Object obj : objects) {
            String csv = serializeObject(obj);
            System.out.println(csv);
        }
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    static class Car {
        private String make;
        private String model;
        private int year;

        public Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }
    }
}
```

In this example, the `CsvSerializer` class uses reflection to serialize objects into CSV format. It dynamically inspects the fields of the given object (`Person` or `Car` in this case) and constructs a CSV string by concatenating the values of those fields. This approach allows the `CsvSerializer` to work with any type of object without needing to know its specific structure at compile time.


Here's another example that demonstrates how reflection can be used to dynamically invoke a method on an object based on the method name provided as a string:

```java
import java.lang.reflect.Method;

public class MethodInvoker {

    public static void invokeMethod(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getMethod(methodName);
        method.invoke(obj);
    }

    public static void main(String[] args) throws Exception {
        MyClass myClass = new MyClass();

        // Invoke the "hello" method using reflection
        invokeMethod(myClass, "hello");

        // Invoke the "goodbye" method using reflection
        invokeMethod(myClass, "goodbye");
    }

    static class MyClass {
        public void hello() {
            System.out.println("Hello, Reflection!");
        }

        public void goodbye() {
            System.out.println("Goodbye, Reflection!");
        }
    }
}
```

In this example, the `MethodInvoker` class contains a method `invokeMethod` that takes an object and a method name as arguments. Using reflection, it obtains the `Method` object for the given method name from the object's class and then invokes that method on the object. This allows you to call methods on an object dynamically, without knowing the method name at compile time.


Here's another example that demonstrates how reflection can be used to inspect annotations on a class and its methods:

```java
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationInspector {

    @MyAnnotation
    public void annotatedMethod() {
        // Method with annotation
    }

    public void nonAnnotatedMethod() {
        // Method without annotation
    }

    public static void main(String[] args) throws Exception {
        AnnotationInspector inspector = new AnnotationInspector();

        // Get class-level annotations
        Class<?> clazz = inspector.getClass();
        Annotation[] classAnnotations = clazz.getAnnotations();
        System.out.println("Class annotations:");
        for (Annotation annotation : classAnnotations) {
            System.out.println(annotation.annotationType().getSimpleName());
        }

        // Get method-level annotations
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("\nMethod annotations:");
        for (Method method : methods) {
            Annotation[] methodAnnotations = method.getAnnotations();
            if (methodAnnotations.length > 0) {
                System.out.println("Method: " + method.getName());
                for (Annotation annotation : methodAnnotations) {
                    System.out.println(annotation.annotationType().getSimpleName());
                }
            }
        }
    }

    @interface MyAnnotation {
        // Annotation definition
    }
}
```

In this example, the `AnnotationInspector` class defines two methods, one of which is annotated with `@MyAnnotation`. The `main` method of the class uses reflection to inspect the annotations present on the class and its methods. It demonstrates how to retrieve class-level annotations and method-level annotations, and then prints out the names of these annotations.



Here's another example that demonstrates how reflection can be used to create and manipulate arrays dynamically:

```java
import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayManipulation {

    public static void main(String[] args) {
        // Create an array dynamically
        int[] intArray = (int[]) Array.newInstance(int.class, 5);

        // Fill the array with values
        for (int i = 0; i < intArray.length; i++) {
            Array.set(intArray, i, i * 10);
        }

        // Print the array
        System.out.println("Original Array: " + Arrays.toString(intArray));

        // Resize the array
        int[] resizedArray = (int[]) resizeArray(intArray, 8);

        // Fill the new elements
        for (int i = 5; i < resizedArray.length; i++) {
            Array.set(resizedArray, i, i * 10);
        }

        // Print the resized array
        System.out.println("Resized Array: " + Arrays.toString(resizedArray));
    }

    public static Object resizeArray(Object oldArray, int newSize) {
        int oldSize = Array.getLength(oldArray);
        Class<?> elementType = oldArray.getClass().getComponentType();
        Object newArray = Array.newInstance(elementType, newSize);
        int preserveLength = Math.min(oldSize, newSize);
        if (preserveLength > 0) {
            System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
        }
        return newArray;
    }
}
```

In this example, the   `ArrayManipulation` class demonstrates how to dynamically create and resize an array using reflection. It first creates an array of integers with a length of 5, fills it with values, and then resizes it to a length of 8, filling the new elements with values as well.

