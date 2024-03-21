You are given an array A of N integers and an integer S. Your task is to compute how many ways one can choose a contiguous fragment of A that has an arithmetic mean equal to S. The arithmetic mean (average) of a fragment is the sum of the elements of the fragment divided by its length. For example, the arithmetic mean of [1, 4, 4, 5] 14/4 = 3.5

Write a function:

class Solution { public int solution(int[] A, int 5); }

which returns the number of contiguous fragments of A whose arithmetic means are equal to S

If the result is greater than 1,000,000,000, your function should return 1,000,000,000.

Examples:

1. Given A = [2, 1, 3] and S = 2 your function should return 3, since the arithmetic means of fragments [2][1, 3] and [2, 1, 3] are equal to 2.

2. Given A = [0, 4, 3, - 1] and S = 2 your function should return 2, since fragments (0.4] and [4, 3,-1) have an arithmetic mean equal to 2

3. Given A = \{2, 1, 4\} and S = 3 your function should return 0, since there exist no

contiguous fragments whose arithmetic mean is equal to 3.

Write an efficient algorithm for the following assumptions:

•N is an integer within the range [1..100,000)

•S is an integer within the range [-1,000,000,000 1,000,000,000)

each element of array A is an integer within the range [- 1000000000, 1000000, 0]

You can solve this problem efficiently by using a sliding window approach. Here's the Java code for the `solution` method:

```java
class Solution {
    public int solution(int[] A, int S) {
        int count = 0;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < A.length; right++) {
            sum += A[right];

            while (left <= right && ((double) sum / (right - left + 1)) > S) {
                sum -= A[left];
                left++;
            }

            if ((double) sum / (right - left + 1) == S) {
                count++;
            }

            if (count > 1_000_000_000) {
                return 1_000_000_000;
            }
        }

        return count;
    }
}
```

This solution iterates over the array with two pointers, `left` and `right`, representing the current window. It calculates the sum of the elements in the window and checks if the arithmetic mean is equal to `S`. If the mean is greater than `S`, it moves the `left` pointer to reduce the window size. If the mean is equal to `S`, it increments the `count`. The solution returns `count` unless it exceeds `1_000_000_000`, in which case it returns `1_000_000_000` as per the requirements.