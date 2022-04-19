package com.yyatsiuk.codingpatterns.binary_search;

/**
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">153. Find Minimum in Rotated Sorted Array</a>
 */
public class RotationCountOfRotatedArray {

    public int findMin(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = (start + end) >>> 1;

            if (mid < end && arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            }
            if (mid > start && arr[mid - 1] > arr[mid]) {
                return arr[mid];
            }

            if (arr[start] < arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return arr[0];
    }

}
