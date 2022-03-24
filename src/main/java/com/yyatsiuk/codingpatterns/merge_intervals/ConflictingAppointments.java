package com.yyatsiuk.codingpatterns.merge_intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://www.educative.io/courses/grokking-the-coding-interview/qVV79nGVgAG">Conflicting Appointments</a>
 * <p>Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.</p>
 * <b>Example 1:</b>
 * Appointments: [[1,4], [2,5], [7,9]]
 * Output: false
 * Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.
 * <p>
 * <b>Example 2:</b>
 * Appointments: [[6,7], [2,4], [8,12]]
 * Output: true
 * Explanation: None of the appointments overlap, therefore a person can attend all of them.
 * <p>
 * <b>Example 3:</b>
 * Appointments: [[4,5], [2,3], [3,6]]
 * Output: false
 * Explanation: Since [4,5] and [3,6] overlap, a person cannot attend both of these appointments.
 */
public class ConflictingAppointments {

    private static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static boolean canAttendAllAppointments(Interval[] intervals) {
        if (intervals.length <= 1) {
            return true;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.start));

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Interval[] intervals = {new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)};
        boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals1 = {new Interval(6, 7), new Interval(2, 4), new Interval(8, 12)};
        result = ConflictingAppointments.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals2 = {new Interval(4, 5), new Interval(2, 3), new Interval(3, 6)};
        result = ConflictingAppointments.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
    }

}
