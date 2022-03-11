package com.yyatsiuk.codingpatterns.sliding_window;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxSumSubArrayOfSizeK {

    public static int findMaxSumSubArray(int k, int[] arr) {
        if (k > arr.length) {
            throw new IllegalArgumentException("k must not be grater than the array length");
        }

        int maxSum = 0;
        int windowStart = 0;
        int windowSum = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            if (windowEnd >= k - 1) {
                maxSum = Math.max(windowSum, maxSum);
                windowSum -= arr[windowStart++];
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        log.info("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
        log.info("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5}));
    }

}
