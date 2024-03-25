## Design patterns

Design patterns are used in software development to solve common design problems and improve the efficiency, maintainability, and scalability of code. Here are some key uses of design patterns:

1. **Standardized Solutions:** Design patterns provide standardized solutions to recurring design problems, making it easier for developers to communicate and understand each other's code.

2. **Code Reusability:** Design patterns promote code reusability by encapsulating the logic for solving specific problems into reusable components.

3. **Maintainability:** Using design patterns can improve the maintainability of code by providing clear and structured solutions that are easier to modify and extend.

4. **Scalability:** Design patterns help in designing scalable solutions by providing guidelines for structuring code that can easily accommodate changes and growth.

5. **Performance:** Some design patterns can improve the performance of an application by optimizing the way objects are created, managed, and accessed.

6. **Design Principles:** Design patterns often embody design principles such as SOLID (Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, and Dependency Inversion), which help in creating well-structured and modular code.

7. **Cross-Platform Development:** Design patterns can be used to create cross-platform solutions that work consistently across different platforms and environments.

8. **Design Evolution:** Design patterns help in evolving the design of an application over time by providing proven solutions to common design problems.

Overall, design patterns serve as a guide for developers to create flexible, maintainable, and scalable software solutions that meet the requirements of modern software development.


> Here's a classification of design patterns with real-life use cases and examples for each type:

### Creational Patterns
1. **Singleton Pattern**
    - **Real-life Use Case**: Database connection pool
    - **Example**: Java's `Runtime` class

2. **Factory Method Pattern**
    - **Real-life Use Case**: Creating different types of vehicles
    - **Example**: Java's `Calendar` class

3. **Abstract Factory Pattern**
    - **Real-life Use Case**: Creating GUI components for different operating systems
    - **Example**: Java's `AbstractFactory` interface

4. **Builder Pattern**
    - **Real-life Use Case**: Building complex objects like custom computer configurations
    - **Example**: Java's `StringBuilder` class

5. **Prototype Pattern**
    - **Real-life Use Case**: Cloning existing objects to create new ones
    - **Example**: Java's `Cloneable` interface

### Structural Patterns
6. **Adapter Pattern**
    - **Real-life Use Case**: Adapting a third-party library to work with your code
    - **Example**: Java's `Arrays.asList()` method

7. **Bridge Pattern**
    - **Real-life Use Case**: Separating a shape from its rendering
    - **Example**: Java's AWT and Swing libraries

8. **Composite Pattern**
    - **Real-life Use Case**: Organizing files and folders in a file system
    - **Example**: Java's `AWT Container` and `Component` classes

9. **Decorator Pattern**
    - **Real-life Use Case**: Adding toppings to a pizza
    - **Example**: Java's `InputStream` and `OutputStream` classes

10. **Facade Pattern**
    - **Real-life Use Case**: Providing a simplified interface to a complex subsystem
    - **Example**: Java's `java.net.URL` class

11. **Flyweight Pattern**
    - **Real-life Use Case**: Sharing common parts of objects to minimize memory usage
    - **Example**: Java's `Integer` and `String` classes

12. **Proxy Pattern**
    - **Real-life Use Case**: Implementing lazy initialization for a resource-heavy object
    - **Example**: Java's `java.lang.reflect.Proxy` class

### Behavioral Patterns
13. **Chain of Responsibility Pattern**
    - **Real-life Use Case**: Processing a request through a chain of objects
    - **Example**: Java's exception handling mechanism

14. **Command Pattern**
    - **Real-life Use Case**: Encapsulating a request as an object
    - **Example**: Java's `Runnable` interface

15. **Interpreter Pattern**
    - **Real-life Use Case**: Interpreting mathematical expressions or SQL queries
    - **Example**: Java's `java.text.SimpleDateFormat` class

16. **Iterator Pattern**
    - **Real-life Use Case**: Iterating over a collection of items
    - **Example**: Java's `Iterator` interface

17. **Mediator Pattern**
    - **Real-life Use Case**: Decoupling interacting objects
    - **Example**: Java's `java.awt.event` package

18. **Memento Pattern**
    - **Real-life Use Case**: Undo mechanism in a text editor
    - **Example**: Java's `java.io.Serializable` interface

19. **Observer Pattern**
    - **Real-life Use Case**: Notifying UI components of underlying data changes
    - **Example**: Java's event listener mechanism

20. **State Pattern**
    - **Real-life Use Case**: Implementing different states for a traffic light
    - **Example**: Java's `Thread` class states

21. **Strategy Pattern**
    - **Real-life Use Case**: Implementing different algorithms for a task
    - **Example**: Java's `Comparator` interface

22. **Template Method Pattern**
    - **Real-life Use Case**: Defining a template for building different types of houses
    - **Example**: Java's `Servlet` class

23. **Visitor Pattern**
    - **Real-life Use Case**: Implementing operations on a collection of objects
    - **Example**: Java's `java.nio.file.FileVisitor` interface

These examples showcase the versatility and applicability of design patterns in various real-world scenarios.   

>Design patterns can be classified into three main categories based on their purpose:

1. **Creational Patterns**: These patterns deal with object creation mechanisms, trying to create objects in a manner suitable to the situation. They often involve creating objects in a way that is more flexible and decoupled from the specific classes.

    - **Factory Method Pattern**: Use when there are multiple implementations of an interface or abstract class, and the exact implementation to be used is decided at runtime. Example: creating different types of documents (PDF, Word, etc.) based on user input.
    - **Abstract Factory Pattern**: Use when there are multiple families of related or dependent objects to be created, but the exact classes are not known beforehand. Example: creating different types of furniture (chair, table, etc.) for different styles (Victorian, Modern, etc.).
    - **Singleton Pattern**: Use when you want to ensure that only one instance of a class is created and provide a global point of access to it. Example: creating a logger class that is shared across the application.

2. **Structural Patterns**: These patterns deal with object composition, creating relationships between objects to form larger structures. They help ensure that if one part of a system changes, the entire system doesn't need to do so.

    - **Adapter Pattern**: Use when you want to convert the interface of a class into another interface that clients expect. Example: adapting an old printer interface to a modern computer.
    - **Decorator Pattern**: Use when you want to add new functionality to an object dynamically without changing its structure. Example: adding toppings to a pizza.
    - **Composite Pattern**: Use when you want to treat individual objects and compositions of objects uniformly. Example: representing a company hierarchy where a manager can have subordinates who can also be managers.

3. **Behavioral Patterns**: These patterns deal with object collaboration and communication, focusing on how objects interact and fulfill individual responsibilities.

    - **Observer Pattern**: Use when you want to define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. Example: implementing an event listener in a GUI.
    - **Strategy Pattern**: Use when you want to define a family of algorithms, encapsulate each one, and make them interchangeable. Example: implementing different sorting algorithms for a list of items.
    - **Chain of Responsibility Pattern**: Use when you want to pass a request along a chain of handlers, where each handler decides either to process the request or to pass it along the chain. Example: processing different types of requests in a web server.

Each of these categories encompasses several design patterns, each with its own specific use cases and implementations.

Design principles and design patterns are related concepts in software design, but they serve different purposes.

**Design Principles:**
- Design principles are general guidelines that can be applied to software design to improve its quality, maintainability, and extensibility.
- Examples of design principles include SOLID principles (Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Dependency Inversion), DRY (Don't Repeat Yourself), KISS (Keep It Simple, Stupid), and YAGNI (You Ain't Gonna Need It).
- These principles help developers write clean, modular, and maintainable code by providing guidelines on how to structure classes, methods, and relationships between components.

**Design Patterns:**
- Design patterns are proven solutions to common problems that occur in software design.
- They are like blueprints that can be applied to specific design problems to solve them in a reusable and understandable way.
- Examples of design patterns include Singleton, Factory Method, Observer, Strategy, and Decorator.
- Design patterns help developers build software that is more flexible, scalable, and easier to maintain by providing well-established solutions to recurring design problems.

In summary, design principles are general guidelines for writing good software, while design patterns are specific solutions to common design problems that adhere to these principles.

> Let's compare design principles and design patterns with an example to illustrate their differences:

**Design Principle: Single Responsibility Principle (SRP)**
- SRP states that a class should have only one reason to change, meaning it should have only one responsibility or job.
- Example: Consider a class `Employee` that represents an employee in a company. According to SRP, the `Employee` class should be responsible for representing an employee's data (e.g., name, age, salary) but not for formatting the data for display.

**Design Pattern: Observer Pattern**
- The Observer pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
- Example: Suppose you have a weather station application where multiple displays show current weather conditions. Here, the weather station acts as the subject (or publisher), and the displays act as observers (or subscribers) that receive updates whenever the weather changes.

**Difference:**
- The Single Responsibility Principle is a design principle that guides how you should structure classes to make them easier to maintain and understand.
- The Observer pattern is a design pattern that provides a specific way to implement a communication mechanism between objects to achieve a particular goal, such as updating multiple displays when the weather changes.

In summary, design principles are general guidelines that inform how you should design classes and components, while design patterns are specific solutions to recurring design problems that can be applied within the context of those principles.


> Here are some interview questions related to design principles:

1. What is SOLID and what do the individual principles stand for?
2. How does the Single Responsibility Principle (SRP) contribute to a better design?
3. Can you explain the Open/Closed Principle (OCP) and why it is important?
4. How does the Liskov Substitution Principle (LSP) help in designing better software?
5. What is the Interface Segregation Principle (ISP) and how does it improve code quality?
6. Can you explain the Dependency Inversion Principle (DIP) and its benefits?
7. How do design patterns relate to SOLID principles?
8. Why is it important for classes and methods to be cohesive?
9. How can you refactor code to adhere to SOLID principles?
10. Can you provide examples of code that violates SOLID principles and suggest improvements?

These questions can help assess a candidate's understanding of fundamental design principles and their ability to apply them in real-world scenarios.


> The SOLID principles are a set of five design principles in object-oriented programming intended to make software designs more understandable, flexible, and maintainable. Let's go through each principle with a use case example:

1. **Single Responsibility Principle (SRP)**: A class should have only one reason to change.

   **Use Case Example**: Consider a class `Employee` that is responsible for storing employee data and also for calculating employee bonuses. According to SRP, this violates the principle because the class has multiple reasons to change. Instead, the class should be split into two: `Employee` (responsible for storing data) and `BonusCalculator` (responsible for calculating bonuses).

2. **Open/Closed Principle (OCP)**: Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.

   **Use Case Example**: Suppose you have a class `Shape` with subclasses `Circle` and `Square`. If you want to add a new shape, you should extend `Shape` rather than modifying it. This way, you keep `Shape` closed for modification but open for extension.
   The Open/Closed Principle (OCP) states that software entities should be open for extension but closed for modification. This means that you should be able to add new functionality to a class or module without changing its existing code. Here's a use case example to illustrate the OCP:

**Use Case: Payment Processing System**

Suppose you have a payment processing system that handles different types of payments, such as credit card payments, PayPal payments, and cryptocurrency payments. Each payment type has its own processing logic.

Initially, you might implement the payment processing system without considering the OCP:

```java
public class PaymentProcessor {
    public void processCreditCardPayment(CreditCardPayment payment) {
        // Process credit card payment
    }

    public void processPayPalPayment(PayPalPayment payment) {
        // Process PayPal payment
    }

    public void processCryptocurrencyPayment(CryptocurrencyPayment payment) {
        // Process cryptocurrency payment
    }
}
```

However, as new payment types are introduced (e.g., mobile payments, digital wallet payments), you would need to modify the `PaymentProcessor` class, violating the OCP.

To adhere to the OCP, you can refactor the design to use interfaces and make the `PaymentProcessor` open for extension:

```java
public interface Payment {
    void processPayment();
}

public class CreditCardPayment implements Payment {
    public void processPayment() {
        // Process credit card payment
    }
}

public class PayPalPayment implements Payment {
    public void processPayment() {
        // Process PayPal payment
    }
}

public class CryptocurrencyPayment implements Payment {
    public void processPayment() {
        // Process cryptocurrency payment
    }
}

public class PaymentProcessor {
    public void processPayment(Payment payment) {
        payment.processPayment();
    }
}
```

With this design, you can easily add new payment types by creating new classes that implement the `Payment` interface, without modifying the existing `PaymentProcessor` class. This follows the OCP principle, as the `PaymentProcessor` class is open for extension (new payment types) but closed for modification (existing code remains unchanged).

3. **Liskov Substitution Principle (LSP)**: Objects of a superclass should be replaceable with objects of its subclasses without affecting the correctness of the program.

   **Use Case Example**: If you have a class `Bird` with a method `fly`, all subclasses of `Bird` (e.g., `Eagle`, `Sparrow`) should also be able to implement `fly` without changing how it behaves.
   Here are some examples of how the Liskov Substitution Principle (LSP) can be applied in an e-commerce application:

1. **Payment Processing**:
    - **Base Class**: `PaymentMethod`
    - **Subclasses**: `CreditCardPayment`, `PayPalPayment`, `GiftCardPayment`
    - **LSP**: All payment methods should be substitutable for each other without affecting the correctness of the payment processing system.

2. **Product Categories**:
    - **Base Class**: `Product`
    - **Subclasses**: `ElectronicsProduct`, `ClothingProduct`, `FoodProduct`
    - **LSP**: All product categories should be substitutable when displaying product details or adding them to the shopping cart.

3. **Shipping Options**:
    - **Base Class**: `ShippingMethod`
    - **Subclasses**: `StandardShipping`, `ExpressShipping`, `SameDayShipping`
    - **LSP**: All shipping methods should be substitutable when calculating shipping costs or selecting a shipping option.

4. **Discount Strategies**:
    - **Base Class**: `DiscountStrategy`
    - **Subclasses**: `PercentageDiscount`, `FixedAmountDiscount`, `BuyOneGetOneFreeDiscount`
    - **LSP**: All discount strategies should be substitutable when calculating discounts for items in the shopping cart.

5. **User Authentication**:
    - **Base Class**: `AuthenticationMethod`
    - **Subclasses**: `UsernamePasswordAuthentication`, `OAuthAuthentication`, `TwoFactorAuthentication`
    - **LSP**: All authentication methods should be substitutable when authenticating users during the login process.

In each of these examples, adhering to the Liskov Substitution Principle ensures that the application's behavior remains consistent and predictable, regardless of the specific subclass instances being used.

Here are some examples of how the Liskov Substitution Principle (LSP) can be applied in an e-commerce application:

1. **Payment Processing**:
    - **Base Class**: `PaymentMethod`
    - **Subclasses**: `CreditCardPayment`, `PayPalPayment`, `GiftCardPayment`
    - **LSP**: All payment methods should be substitutable for each other without affecting the correctness of the payment processing system.

2. **Product Categories**:
    - **Base Class**: `Product`
    - **Subclasses**: `ElectronicsProduct`, `ClothingProduct`, `FoodProduct`
    - **LSP**: All product categories should be substitutable when displaying product details or adding them to the shopping cart.

3. **Shipping Options**:
    - **Base Class**: `ShippingMethod`
    - **Subclasses**: `StandardShipping`, `ExpressShipping`, `SameDayShipping`
    - **LSP**: All shipping methods should be substitutable when calculating shipping costs or selecting a shipping option.

4. **Discount Strategies**:
    - **Base Class**: `DiscountStrategy`
    - **Subclasses**: `PercentageDiscount`, `FixedAmountDiscount`, `BuyOneGetOneFreeDiscount`
    - **LSP**: All discount strategies should be substitutable when calculating discounts for items in the shopping cart.

5. **User Authentication**:
    - **Base Class**: `AuthenticationMethod`
    - **Subclasses**: `UsernamePasswordAuthentication`, `OAuthAuthentication`, `TwoFactorAuthentication`
    - **LSP**: All authentication methods should be substitutable when authenticating users during the login process.

In each of these examples, adhering to the Liskov Substitution Principle ensures that the application's behavior remains consistent and predictable, regardless of the specific subclass instances being used.


4. **Interface Segregation Principle (ISP)**: A client should not be forced to implement interfaces they do not use, and the dependency of one class on another should be kept to a minimum.

   **Use Case Example**: Suppose you have an `Employee` interface with methods for both full-time and part-time employees. Instead, you can split it into `FullTimeEmployee` and `PartTimeEmployee` interfaces, each with methods relevant to their respective types.

5. **Dependency Inversion Principle (DIP)**: High-level modules should not depend on low-level modules. Both should depend on abstractions. Additionally, abstractions should not depend on details. Details should depend on abstractions.

   **Use Case Example**: Consider a class `DatabaseService` that directly depends on a specific database implementation (`MySQLDatabase`). Instead, `DatabaseService` should depend on an abstract `Database` interface, and `MySQLDatabase` should implement this interface. This way, you can easily switch to a different database implementation without modifying `DatabaseService`.

These principles help in creating more maintainable and scalable software by promoting better design practices and reducing code duplication and complexity.

> Correctness
>>In the context of the Liskov Substitution Principle (LSP), "correctness" refers to the behavior and functionality that the base class (in this case, the `Product` class) provides. According to LSP, a subclass (such as `DiscountedProduct`) should be able to substitute the base class without changing the expected behavior of the program.
>>>In the example provided, the `DiscountedProduct` class extends the `Product` class and adds discount functionality. Despite this extension, the `DiscountedProduct` class still behaves like a `Product` class (it can be used in place of a `Product` instance), and the core functionality of the `Product` class (e.g., getting the price) remains unchanged. This adherence to the expected behavior of the base class demonstrates the Liskov Substitution Principle.
>>>>Imagine you have a basic phone that can make calls and send messages. You decide to upgrade to a smartphone, which can do everything your basic phone can do, plus it can also access the internet and run apps. Despite these additional features, you can still make calls and send messages on your smartphone just like you did with your basic phone. This is similar to the Liskov Substitution Principle, where the smartphone (subclass) can be used in place of the basic phone (base class) without changing the core functionality of making calls and sending messages.

