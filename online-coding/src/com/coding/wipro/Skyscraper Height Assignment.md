You are given an array A of N integers, representing the maximum heights of N skyscrapers to be built

Your task is to specify the actual heights of the skyscrapers, given that:

the height of the K-th skyscraper should be positive and not bigger than A[K]

no two skyscrapers should be of the same height:

the total sum of the skyscrapers' heights should be the maximum possible.

Write a function:

class Solution (public int[] solution (int[] A); }

that, given an array A of N integers, returns an array B of N integers where B[K) is the assigned height of the K-th skyscraper satisfying the above conditions.

If there are several possible answers, the function may return any of them. You may assume that it is always possible to buildrall skyscrapers while fulfilling all the requirements.

Examples:

1. Given A = [1, 2, 3], your function should return [1, 2, 3], as all of the skyscrapers may be built to

their maximum height.

2. Given A = [9, 4, 3, 7, 71, your function may return [9, 4, 3, 7, 6]. Note that [9, 4, 3, 6, 7] is also a valid answer. It is not possible for the last two skyscrapers to have the same height. The height of one of them should be 7 and the other should be 6.

3. Given A [2, 5, 4, 5, 51, your function should return [1, 2, 3, 4, 5].

Write an efficient algorithm for the following assumptions:

•N is an integer within the range [1..50,000);

each element of array A is an integer within the range [11,000,000,000), there is always a solution for the given input.

Copyright 2009-2024 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited