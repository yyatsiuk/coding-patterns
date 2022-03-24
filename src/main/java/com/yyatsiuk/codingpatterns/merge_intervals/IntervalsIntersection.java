package com.yyatsiuk.codingpatterns.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/interval-list-intersections/">986. Interval List Intersections</a>
 * <p>
 * Given two lists of intervals, find the intersection of these two lists. Each list consists of disjoint intervals sorted on their start time.
 * <p>
 * <b>Example 1:</b>
 * Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
 * Output: [2, 3], [5, 6], [7, 7]
 * Explanation: The output list contains the common intervals between the two lists.
 * <p>
 * <b>Example 2:</b>
 * Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
 * Output: [5, 7], [9, 10]
 * Explanation: The output list contains the common intervals between the two lists.
 */
public class IntervalsIntersection {

    public static int[][] intervalIntersection(int[][] arr1, int[][] arr2) {
        List<int[]> intervalsIntersection = new ArrayList<>();

        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {

            if ((arr1[i][0] >= arr2[j][0] && arr1[i][0] <= arr2[j][1]) || (arr2[j][0] >= arr1[i][0] && arr2[j][0] <= arr1[i][1])) {
                int intersectionStart = Math.max(arr1[i][0], arr2[j][0]);
                int intersectionEnd = Math.min(arr1[i][1], arr2[j][1]);
                intervalsIntersection.add(new int[]{intersectionStart, intersectionEnd});
            }

            if (arr1[i][1] < arr2[j][1]) i++;
            else j++;

        }

        return intervalsIntersection.toArray(new int[intervalsIntersection.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervalIntersections = intervalIntersection(
                new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});

        System.out.println(Arrays.deepToString(intervalIntersections));
    }

}
