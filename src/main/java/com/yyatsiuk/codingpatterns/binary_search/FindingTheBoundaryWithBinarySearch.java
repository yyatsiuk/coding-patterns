package com.yyatsiuk.codingpatterns.binary_search;

/**
 * An array of boolean values is divided into two sections; the left section consists of all false and the right section consists of all true.
 * Find the boundary of the right section, i.e. the index of the first true element. If there is no true element, return -1.
 * <p>
 * Input: arr = [false, false, true, true, true]
 * <p>
 * Output: 2
 * <p>
 * Explanation: first true's index is 2.
 */
public class FindingTheBoundaryWithBinarySearch {

    public static int findBoundary(boolean[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int boundaryIndex = -1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (arr[mid]) {
                right = mid - 1;
                boundaryIndex = mid;
            } else {
                left = mid + 1;
            }
        }

        return boundaryIndex;
    }

}
