package com.yyatsiuk.codingpatterns.binary_search;

/**
 * <a href="https://www.educative.io/courses/grokking-the-coding-interview/mymvP915LY9">Minimum Difference Element</a>
 * <p>
 * Given an array of numbers sorted in ascending order, find the element in the array that has the minimum difference with the given ‘key’.
 * </p>
 * <p>
 * <b>Example 1:</b>
 * Input: [4, 6, 10], key = 7
 * Output: 6
 * Explanation: The difference between the key '7' and '6' is minimum than any other number in the array
 * </p>
 * <p>
 * <b>Example 2:</b>
 * Input: [4, 6, 10], key = 4
 * Output: 4
 * </p>
 */
public class MinimumDifference {

    public static int searchMinDiffElement(int[] arr, int key) {
        int position = binarySearch(arr, key);
        return arr[position];
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (target < arr[mid]) {
                high = mid - 1;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return Math.max(low - 1, 0);
    }

    public static void main(String[] args) {
        System.out.println(MinimumDifference.searchMinDiffElement(new int[]{4, 6, 10}, 7));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[]{4, 6, 10}, 4));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[]{1, 3, 8, 10, 15}, 12));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[]{4, 6, 10}, 17));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[]{1}, 2));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[]{0, 1}, -1));
    }

}
