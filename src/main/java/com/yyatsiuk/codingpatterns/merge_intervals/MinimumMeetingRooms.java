package com.yyatsiuk.codingpatterns.merge_intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/meeting-rooms-ii/">253. Meeting Rooms II</a>
 * <p>
 * Given a list of intervals representing
 * the start and end time of ‘N’ meetings, find the minimum number of rooms required to hold all the meetings.
 * <p>
 * <b>Example 1:</b>
 * Meetings: [[1,4], [2,5], [7,9]]
 * Output: 2
 * Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can
 * occur in any of the two rooms later.
 * <p>
 * <b>Example 2:</b>
 * Meetings: [[6,7], [2,4], [8,12]]
 * Output: 1
 * Explanation: None of the meetings overlap, therefore we only need one room to hold all meetings.
 * <p>
 * <b>Example 3:</b>
 * Meetings: [[1,4], [2,3], [3,6]]
 * Output:2
 * Explanation: Since [1,4] overlaps with the other two meetings [2,3] and [3,6], we need two rooms to
 * hold all the meetings.
 */
public class MinimumMeetingRooms {

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals.length;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!minHeap.isEmpty() && interval[0] >= minHeap.peek()) {
                minHeap.poll();
            }

            minHeap.add(interval[1]);
        }

        return minHeap.size();
    }

    public static void main(String[] args) {
        System.out.println("Result = " + minMeetingRooms(new int[][]{{5, 8}, {6, 8}}));
        System.out.println("Result = " + minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println("Result = " + minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));
    }

}
