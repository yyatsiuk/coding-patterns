package com.yyatsiuk.codingpatterns.merge_intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/employee-free-time/">759. Employee Free Time</a>
 * <p>
 * For ‘K’ employees, we are given a list of intervals representing each employee’s working hours.
 * Our goal is to determine if there is a free interval which is common to all employees.
 * You can assume that each list of employee working hours is sorted on the start time.
 * <p>
 * <b>Example 1:</b>
 * Input: Employee Working Hours=[[[1,3], [5,6]], [[2,3], [6,8]]]
 * Output: [3,5]
 * Explanation: All the employees are free between [3,5].
 * <p>
 * <b>Example 2:</b>
 * Input: Employee Working Hours=[[[1,3], [9,12]], [[2,4]], [[6,8]]]
 * Output: [4,6], [8,9]
 * Explanation: All employees are free between [4,6] and [8,9].
 * <p>
 * <b>Example 3:</b>
 * Input: Employee Working Hours=[[[1,3]], [[2,4]], [[3,5], [7,9]]]
 * Output: [5,7]
 * Explanation: All employees are free between [5,7].
 */
public class EmployeeFreeTime {

    private static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static class EmployeeInterval {
        Interval interval; // interval representing employee's working hours
        int employeeIndex; // index of the list containing working hours of this employee
        int intervalIndex; // index of the interval in the employee list

        public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex) {
            this.interval = interval;
            this.employeeIndex = employeeIndex;
            this.intervalIndex = intervalIndex;
        }
    }

    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        if (schedule.isEmpty()) {
            return Collections.emptyList();
        }

        List<Interval> result = new ArrayList<>();
        // PriorityQueue to store one interval from each employee
        Queue<EmployeeInterval> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(a -> a.interval.start));

        // insert the first interval of each employee to the queue
        for (int i = 0; i < schedule.size(); i++)
            minHeap.offer(new EmployeeInterval(schedule.get(i).get(0), i, 0));

        Interval previousInterval = minHeap.peek().interval;
        while (!minHeap.isEmpty()) {
            EmployeeInterval queueTop = minHeap.poll();
            // if previousInterval is not overlapping with the next interval, insert a free interval
            if (previousInterval.end < queueTop.interval.start) {
                result.add(new Interval(previousInterval.end, queueTop.interval.start));
                previousInterval = queueTop.interval;
            } else { // overlapping intervals, update the previousInterval if needed
                if (previousInterval.end < queueTop.interval.end)
                    previousInterval = queueTop.interval;
            }

            // if there are more intervals available for the same employee, add their next interval
            List<Interval> employeeSchedule = schedule.get(queueTop.employeeIndex);
            if (employeeSchedule.size() > queueTop.intervalIndex + 1) {
                minHeap.offer(new EmployeeInterval(employeeSchedule.get(queueTop.intervalIndex + 1), queueTop.employeeIndex,
                        queueTop.intervalIndex + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<>(List.of(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<>(List.of(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<>(List.of(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<>(List.of(new Interval(2, 4))));
        input.add(new ArrayList<>(List.of(new Interval(6, 8))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<>(List.of(new Interval(1, 3))));
        input.add(new ArrayList<>(List.of(new Interval(2, 4))));
        input.add(new ArrayList<>(List.of(new Interval(3, 5), new Interval(7, 9))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
    }

}
