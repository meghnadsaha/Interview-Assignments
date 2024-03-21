### Data Structures: Multiple Graphs



The data includes information for players, with M data points recorded for each player. Each data point shows how well a star player performed throughout the year in their sports

team To find the player of the year, you simply need to figure out who stayed at the top for the

longest time,

This means finding the player whose performance was consistently better than all others for the most extended period of the year.

Find the player of the year.

Function Description

In the provided code snippet, implement the provided `playerOfTheYear(...)` method using the variables to print the output. You can write your code in the space below the phrase "WRITE YOUR LOGIC HERE".

There will be multiple test cases running so the Input and Output should match exactly as provided

The base output variable result is set to a default value of `-404`, which can be modified. Additionally, you can add or remove these output variables.

Input Format

The first line contains an integer `N`, denoting the number of players.

The next line contains an integer `M`, denoting the number of data points per player. 
The next `N` lines contain `M` space-separated integers denoting the relative performance of player/during that data point duration.

Sample Input
```java
3 denotes N
4 denotes M
1 3 4 5 Player 1 Performance
7 2 3 4 Player 2 Performance
1 3 2 1 Player 3 Performance

```
Output Format

The output contains a single integer denoting the player of the year.

Sample Output
`1`

Explanation
`1` Player has been on the top for 3 data point durations, which is the maximum. Hence, the output is `1`.