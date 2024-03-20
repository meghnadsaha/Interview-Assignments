package com.coding.sepient;


class FindMedianSortedArrays {

    static int p1 = 0, p2 = 0;

    public static int getMinVal ( int[] nums1 , int[] nums2 ) {

        if (p1 < nums1.length && p2 < nums2.length) {
            return nums1[p1] < nums2[p2]?nums1[p1++]:nums2[p2++];
        } else if (p1 < nums1.length) {
            return nums1[p1++];
        } else if (p2 < nums2.length) {
            return nums2[p2++];
        }

        return -1;
    }

    public static double findMedianSortedArrays ( int[] nums1 , int[] nums2 ) {
        int m = nums1.length, n = nums2.length;
        if ((m + n) % 2 == 0) {
            for (int i = 0 ; i < (m + n) / 2 - 1 ; ++i) {
                int temp = getMinVal(nums1 , nums2);
            }
            return (double) (getMinVal(nums1 , nums2) + getMinVal(nums1 , nums2)) / 2;
        } else {
            for (int i = 0 ; i < (m + n) / 2 ; ++i) {
                int temp = getMinVal(nums1 , nums2);
            }
            return (double) (getMinVal(nums1 , nums2));
        }

    }

    public static void main ( String[] args ) {
        int nums1[] = new int[]{1 , 2};
        int nums2[] = new int[]{3 , 4};

        System.out.println(findMedianSortedArrays(nums1 , nums2));
    }
}