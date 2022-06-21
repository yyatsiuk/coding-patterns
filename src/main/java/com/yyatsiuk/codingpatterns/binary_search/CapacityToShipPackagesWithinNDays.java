package com.yyatsiuk.codingpatterns.binary_search;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <a href="https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/">1011. Capacity To Ship Packages Within D Days</a>
 */
public class CapacityToShipPackagesWithinNDays {

    /**
     * O (N * log(N))
     */
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = Integer.MIN_VALUE;
        int sum = 0;
        for (int w : weights) {
            maxWeight = Math.max(maxWeight, w);
            sum += w;
        }

        int left = maxWeight;
        int right = sum;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (canShip(weights, mid, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    private boolean canShip(int[] weights, int capacity, int maxDays) {
        int sum = 0;
        int days = 1;
        for (int weight : weights) {
            if ((sum + weight) <= capacity) {
                sum += weight;
            } else {
                sum = weight;
                days++;
            }
        }

        return days <= maxDays;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = splitWords(scanner.nextLine()).stream().mapToInt(Integer::parseInt).toArray();
        scanner.close();
        int res = new CapacityToShipPackagesWithinNDays().shipWithinDays(arr, 4);
        System.out.println(res);
    }

}
