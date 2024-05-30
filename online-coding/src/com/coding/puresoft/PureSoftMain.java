package com.coding.puresoft;

import java.util.concurrent.atomic.AtomicInteger;

public class PureSoftMain {
    private AtomicInteger value = new AtomicInteger(0);

//    public int getValue () {
//        return value.get();
//    }
//
//    public void increment () {
//        int current;
//        int next;
//        do {
//            current = current.get();
//            next = current  + 1;
//        }while (!value.compareAndSet(current,next));
//    }

    //    Given an integer array nums, find the
//    subarray
//    with the largest sum, and return its sum.
//
//    Input: [-3, -4, 5, -1, 2, -4, 6, -1]
//    Output: 8
//    Explanation: Subarray [5, -1, 2, -4, 6] is the max sum contiguous subarray with sum 8.
//    Input: [-2, 3, -1, 2]
//    Output: 4
//    Explanation: Subarray [3, -1, 2] is the max sum contiguous subarray with sum 4.

    public static void main ( String[] args ) {
       //int [] nums = {-3, -4, 5, -1, 2, -4, 6, -1};
//       int nums[] ={5, -1, 2, -4, 6};
        int  nums[]={-2, 3, -1, 2};
       int maxSum = maxSubArraySum(nums);
        System.out.println("maxSubArraySum is : "+maxSum);
    }

    private static int maxSubArraySum ( int[] nums ) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0 ; i <nums.length  ; i++) {
            currentSum += nums[i];
            if(currentSum>maxSum){
                maxSum= currentSum;
            }
            if(currentSum<0){
                currentSum =0;
            }
        }
        return  maxSum;
    }
}
