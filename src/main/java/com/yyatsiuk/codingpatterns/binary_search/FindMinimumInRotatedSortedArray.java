package com.yyatsiuk.codingpatterns.binary_search;

/**
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">153. Find Minimum in Rotated Sorted Array</a>
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return arr[right];
    }

}
