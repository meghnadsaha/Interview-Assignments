package com.coding.emphasis;

public class Emphasis {


    private static int count = 1;
    private static final Object lock = new Object();

    public static void main ( String[] args ) {

        Thread oddThread = new Thread(() -> {
            synchronized (lock) {
                while (count <= 20) {
                    if (count % 2 != 0) {
                        System.out.println("Odd : " + count);
                        count++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            synchronized (lock) {
                while (count <= 20) {
                    if (count % 2 == 0) {
                        System.out.println("Even : " + count);
                        count++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }


//    public static void main ( String[] args ) {
//        int array[] = {1 , 3 , 5 , 7 , 9 , 11 , 13 , 15 , 17};
//        int target = 7;
//        int index = binarSearch(array , target);
//        if (index != -1) {
//            System.out.println("Element found at index : "+index);
//        }
//    }

    private static int binarSearch ( int[] array , int target ) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
