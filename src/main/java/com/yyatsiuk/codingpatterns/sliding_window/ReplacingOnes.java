package com.yyatsiuk.codingpatterns.sliding_window;

import lombok.extern.slf4j.Slf4j;

/**
 * Given an array containing 0s and 1s,
 * if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.
 */
@Slf4j
public class ReplacingOnes {

    public static int findLength(int[] arr, int k) {
        int maxLength = 0;
        int maxOnesCount = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1) {
                maxOnesCount++;
            }

            if (windowEnd - windowStart + 1 - maxOnesCount > k) {
                if (arr[windowStart] == 1) {
                    maxOnesCount--;
                }
                windowStart++;
            }

            maxLength = Math.max(windowEnd - windowStart + 1, maxLength);
        }


        return maxLength;
    }

    public static void main(String[] args) {
        log.info("Result = {}", ReplacingOnes.findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
        log.info("Result = {}", ReplacingOnes.findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }

}
