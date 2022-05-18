package com.yyatsiuk.codingpatterns.two_pointers;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

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
            if (i > 0 && nums[i - 1] == nums[i]) continue;

            int compliment = nums[i] * -1;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == compliment) {
                    triplets.add(List.of(nums[left], nums[right], nums[i]));
                    left++;
                    right--;

                    while (left < nums.length && nums[left - 1] == nums[left]) left++;
                    while (right >= 0 && nums[right + 1] == nums[right]) right--;
                } else if (nums[left] + nums[right] > compliment) right--;
                else left++;
            }
        }
        return triplets;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; j++) {
                    int num = -nums[i] - nums[j];
                    if (seen.containsKey(num) && seen.get(num) == 1) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], num);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        }

        return new ArrayList<>(res);
    }


    public static void main(String[] args) {
        log.info("Result = {}", TripletSumToZero.searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        log.info("Result = {}", TripletSumToZero.searchTriplets(new int[]{-5, 2, -1, -2, 3}));
    }

}
