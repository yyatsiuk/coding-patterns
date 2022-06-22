package com.yyatsiuk.codingpatterns.binary_search;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * <a href="https://algo.monster/problems/newspapers_split">Newspapers</a>
 */
public class Newspapers {

    public static int newspapersSplit(List<Integer> newspapersReadTimes, int numCoworkers) {
        int totalTime = 0;
        int maxTime = Integer.MIN_VALUE;
        for (int timeToRead : newspapersReadTimes) {
            totalTime += timeToRead;
            maxTime = maxTime >= timeToRead ? maxTime : timeToRead;
        }

        int lo = maxTime;
        int hi = totalTime;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (canRead(newspapersReadTimes, mid, numCoworkers)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return hi;
    }

    private static boolean canRead(List<Integer> newspapersReadTimes, int amountOfTime, int numCoworkers) {
        int coworkersNeeded = 1;
        int timeSpent = 0;
        for (int timeToRead : newspapersReadTimes) {
            if (timeSpent + timeToRead <= amountOfTime) {
                timeSpent += timeToRead;
            } else {
                coworkersNeeded++;
                timeSpent = timeToRead;
            }
        }

        return coworkersNeeded <= numCoworkers;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> newspapersReadTimes = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int numCoworkers = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = newspapersSplit(newspapersReadTimes, numCoworkers);
        System.out.println(res);
    }
}
