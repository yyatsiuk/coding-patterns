package com.yyatsiuk.codingpatterns.sliding_window;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class AverageOfSubarrayOfSizeK {

    public static double[] findAveragesBrute(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1];
        for (int i = 0; i <= arr.length - k; i++) {
            // find sum of next 'k' elements
            double sum = 0;
            for (int j = i; j < i + k; j++)
                sum += arr[j];
            result[i] = sum / k; // calculate average
        }

        return result;
    }

    public static double[] findAverageOptimal(int k, int[] arr) {
        if (k > arr.length) {
            throw new IllegalArgumentException("k must not be grater than the array length");
        }

        double[] result = new double[arr.length - k + 1];
        double windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            if (windowEnd >= k - 1) {
                result[windowStart] = windowSum / k;
                windowSum -= arr[windowStart++];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        double[] resultBrute = AverageOfSubarrayOfSizeK.findAveragesBrute(5, new int[]{1, 3, 2, 6});
        double[] resultOptimal = AverageOfSubarrayOfSizeK.findAverageOptimal(5, new int[]{1, 3, 2, 6});

        log.info("[Brute] Averages of subarrays of size K: " + Arrays.toString(resultBrute));
        log.info("[Optimal] Averages of subarrays of size K: " + Arrays.toString(resultOptimal));
    }

}
