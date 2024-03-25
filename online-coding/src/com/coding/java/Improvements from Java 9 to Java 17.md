Java has introduced several features and improvements from Java 9 to Java 17. Here's a summary of some of the key features introduced in each version:

Java 8 (March 2014):

1. **Lambda Expressions: Allow you to treat functionality as a method argument.**
2. **Stream API: Introduces a new abstraction for working with collections of elements.**
3. **Default Methods: Allows interfaces to have methods with implementation.**
4. **Functional Interfaces: An interface with a single abstract method, used for lambda expressions.**
5. **Method References: Provides a way to refer to methods or constructors without invoking them.**

Java 9:
1. **Module System (Project Jigsaw)**: Introduces the module system to improve modularity of the JDK and applications.
2. **JShell (Java REPL)**: Provides an interactive shell for evaluating Java expressions and statements.
3. **Private Methods in Interfaces**: Allows interfaces to have private methods, reducing code duplication in default methods.
4. **Try-With-Resources Enhancements**: Allows effectively final variables to be used in the try-with-resources statement.
5. **Improved Stream API**: Introduces several new methods in the Stream API to simplify common tasks.

Java 10:
1. **Local-Variable Type Inference (var)**: Introduces the `var` keyword for local variable type inference.
2. **Application Class-Data Sharing**: Improves startup time and reduces memory footprint by sharing common class metadata.
3. **Garbage Collector Interface**: Introduces a new interface for the garbage collector, making it easier to add new garbage collectors.
4. **Thread-Local Handshakes**: Allows threads to execute code at safepoints without stopping the world.

Java 11:
1. **HTTP Client (Standard)**: Introduces a new HTTP client as a standard feature, replacing the old `HttpURLConnection` API.
2. **Local-Variable Syntax for Lambda Parameters**: Allows `var` to be used for lambda parameters.
3. **String Methods**: Introduces several new methods in the `String` class for common tasks.
4. **Epsilon Garbage Collector**: Introduces a no-op garbage collector for performance testing and debugging.

Java 12:
1. **Switch Expressions (Preview)**: Enhances the switch statement to be used as an expression, with a more concise syntax.
2. **Compact Number Formatting**: Introduces a new formatter for compact number formatting.
3. **JVM Constants API**: Introduces a new API for defining constants in a more efficient way.

Java 13:
1. **Text Blocks (Preview)**: Introduces text blocks for writing multiline strings more easily.
2. **Switch Expressions (Standard)**: Makes switch expressions a standard feature, removing the preview status.
3. **Reimplement the Legacy Socket API**: Improves the underlying implementation of the legacy socket API for better performance and maintainability.

Java 14:
1. **JFR Event Streaming**: Introduces the ability to stream Java Flight Recorder (JFR) events.
2. **Switch Expressions (Standard)**: Adds additional features to switch expressions, including yield statements.
3. **Records (Preview)**: Introduces record classes for more concise data classes.

Java 15:
1. **Text Blocks (Standard)**: Removes the preview status from text blocks, making them a standard feature.
2. **Sealed Classes (Preview)**: Introduces sealed classes for more control over class hierarchies.
3. **Hidden Classes**: Introduces a new mechanism for creating classes that are not discoverable via reflection.

Java 16:
1. **Records (Standard)**: Removes the preview status from records, making them a standard feature.
2. **Pattern Matching for instanceof**: Enhances the instanceof operator with pattern matching capabilities.
3. **Foreign-Memory Access API (Incubator)**: Introduces an API for safe and efficient access to foreign memory.

Java 17:
1. **Sealed Classes (Standard)**: Removes the preview status from sealed classes, making them a standard feature.
2. **Pattern Matching for switch (Standard)**: Removes the preview status from pattern matching for switch, making it a standard feature.
3. **New macOS Rendering Pipeline**: Introduces a new rendering pipeline for macOS, improving performance and reliability.

These are just some of the key features and improvements introduced in Java from version 9 to version 17. Each version also includes various performance improvements, bug fixes, and other enhancements.