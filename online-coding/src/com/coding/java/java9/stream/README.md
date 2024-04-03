Java 9 introduced several new methods in the Stream API to simplify common tasks and improve usability. Some of the key additions include:

1. **takeWhile()**: Returns a stream consisting of the elements from the original stream that match a given predicate. It stops when the first element is encountered that does not match the predicate.

2. **dropWhile()**: Returns a stream consisting of the remaining elements of the original stream after dropping the longest prefix of elements that match a given predicate. It continues until an element is encountered that does not match the predicate.

3. **ofNullable()**: Returns a sequential Stream containing a single non-null element, if the specified element is non-null, otherwise returns an empty Stream.

4. **iterate()**: Overloaded iterate method that allows you to specify a predicate to stop the iteration.

5. **toList()**, **toSet()**, **toMap()**: Collectors to easily collect elements into a List, Set, or Map.

6. **flatMapping()**: Similar to flatMap, but allows you to specify a downstream collector.

7. **teeing()**: A collector that allows you to apply two collectors to the same input and then combine their results.

8. **filtering()**: A collector that filters elements based on a predicate before applying another collector.

9. **mapping()**: A collector that applies a mapping function to the elements before collecting them.

These additions provide more flexibility and convenience when working with streams, making it easier to perform common operations. They also align the Stream API more closely with functional programming concepts, making Java streams more expressive and powerful.