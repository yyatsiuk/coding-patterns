package com.yyatsiuk.codingpatterns.merge_intervals;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.com/problems/insert-interval/">57. Insert Interval</a>
 * <p>
 * Given a list of non-overlapping intervals sorted by their start time,
 * insert a given interval at the correct position and merge all necessary intervals to produce a list that has only mutually exclusive intervals.
 * <p>
 * <b>Example 1:</b>
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
 * Output: [[1,3], [4,7], [8,12]]
 * Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
 * <p>
 * <b>Example 2:</b>
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
 * Output: [[1,3], [4,12]]
 * Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we merged them into [4,12].
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int idx = 0;
        int n = intervals.length;
        ArrayList<int[]> output = new ArrayList<>();

        // add all intervals before newInterval
        while (idx < n && intervals[idx][1] < newStart)
            output.add(intervals[idx++]);


        while (idx < n && intervals[idx][0] <= newEnd) {
            newStart = Math.min(newStart, intervals[idx][0]);
            newEnd = Math.max(newEnd, intervals[idx][1]);
            idx++;
        }
        output.add(new int[]{newStart, newEnd});

        // add all intervals after newInterval
        while (idx < n)
            output.add(intervals[idx++]);

        return output.toArray(new int[0][0]);
    }

}
