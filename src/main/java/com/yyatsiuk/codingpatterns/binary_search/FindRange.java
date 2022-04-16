package com.yyatsiuk.codingpatterns.binary_search;

/**
 * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">34. Find First and Last Position of Element in Sorted Array</a>
 */
public class FindRange {

    public static int[] findRange(int[] arr, int target) {
        int[] result = new int[]{-1, -1};
        int minIndex = binarySearch(arr, target, false);
        if (minIndex == -1) {
            return result;
        }

        int maxIndex = binarySearch(arr, target, true);
        result[0] = minIndex;
        result[1] = maxIndex;

        return result;
    }

    private static int binarySearch(int[] arr, int target, boolean findMaxIndex) {
        int targetIndex = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (target < arr[middle]) {
                end = middle - 1;
            } else if (target > arr[middle]) {
                start = middle + 1;
            } else {
                targetIndex = middle;
                if (findMaxIndex) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }

        return targetIndex;
    }

    public static void main(String[] args) {
        int[] result = FindRange.findRange(new int[]{4, 6, 6, 6, 9}, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[]{1, 3, 8, 10, 15}, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[]{1, 3, 8, 10, 15}, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }

}
