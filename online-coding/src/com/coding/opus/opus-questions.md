### 1.Find the word Given a 2D grid of characters and a single word, write a utility method to determine if the given word is vertically present (forward direction or reverse direction) in the grid or not.

Do NOT use functions like String.compare or String.equals for comparison.

Assumptions:

- The grid is #N x N (always a square)

- All characters in the grid are lowercase alphabets

Example 1: the word 'tend' is present in the second column in the following grid. Ignore the spaces.
```java
char[][] grid1 = {
        {'a', 's', 't', 'd', 'v'},
        {'f', 'r', 'e', 'k', 'l'},
        {'s', 'r', 'n', 'g', 'y'},
        {'f', 'e', 'd', 'm', 'c'},
        {'s', 'd', 'g', 't', 'y'}
        };
```

Example 2: the word 'find' is present in the second column in the following grid. Ignore the spaces.

```java
char[][] grid2 = {
{'a', 'd', 'f', 'd', 'v'},
{'f', 'n', 'e', 'k', 'l'},
{'s', 'i', 'h', 'g', 'y'},
{'f', 'f', 'd', 'm', 'c'},
{'s', 'd', 'g', 't', 'y'}
};
```

![https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/](https://media.geeksforgeeks.org/wp-content/cdn-uploads/Search_a_Word.png)

### 2.Design using composite design pattern

Assuming that you are developing software for a residential society, you are given the below requirements.

- A society has one or more buildings

- Each building has one or more flats

Society and Buildings have names

- Flats have flat numbers

Your job is to write a program that outputs one line for each flat in the format 'socity-name:building-name:flat-number'. For example, when there are 2 buildings in a society and each one has 2 flats, the output should be as below.

society-1:building-1:01

society-1:building-1:02

society-1:building-2:01

society-1:building-2:02

You must ensure that

- the code is extensible to accommodate new requirements

- the code uses proper abstractions

- the code implements encapsulation properly

