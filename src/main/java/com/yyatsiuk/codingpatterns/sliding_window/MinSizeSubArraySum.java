package com.yyatsiuk.codingpatterns.sliding_window;

import lombok.extern.slf4j.Slf4j;

/**
 * Given an array of positive numbers and a positive number ‘S,’
 * find the length of the smallest contiguous subarray whose
 * sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
 */
@Slf4j
public class MinSizeSubArraySum {

    public static int findMinSubArray(int s, int[] arr) {
        int windowSum = 0;
        int windowStart = 0;
        int minArrSize = arr.length + 1;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            while (windowSum >= s) {
                minArrSize = Math.min((windowEnd - windowStart) + 1, minArrSize);
                windowSum -= arr[windowStart++];
            }
        }

        return minArrSize != arr.length + 1 ? minArrSize : 0;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2});
        log.info("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 8});
        log.info("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[]{3, 4, 1, 1, 6});
        log.info("Smallest subarray length: " + result);
    }

}
