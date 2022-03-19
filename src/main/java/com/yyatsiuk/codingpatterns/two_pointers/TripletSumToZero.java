package com.yyatsiuk.codingpatterns.two_pointers;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/3sum/">15. 3Sum</a>
 * <p>
 * Given an integer array nums, return all the triplets
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <b>Example 1:</b>
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 * <p>
 * <b>Example 2:</b>
 * Input: [-5, 2, -1, -2, 3]
 * Output: [[-5, 2, 3], [-2, -1, 3]]
 * Explanation: There are two unique triplets whose sum is equal to zero.
 */
@Slf4j
public class TripletSumToZero {

    public static List<List<Integer>> searchTriplets(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int x = nums[i];
            int minusX = x * -1;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int y = nums[left];
                int z = nums[right];
                if (minusX == y + z) {
                    List<Integer> triplet = List.of(x, y, z);
                    triplets.add(triplet);
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;

                } else if (minusX > y + z) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplets;
    }

    public static void main(String[] args) {
        log.info("Result = {}", TripletSumToZero.searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        log.info("Result = {}", TripletSumToZero.searchTriplets(new int[]{-5, 2, -1, -2, 3}));
    }

}
