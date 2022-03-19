package com.yyatsiuk.codingpatterns.two_pointers;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/4sum/">18. 4Sum</a>
 * <p>
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * <p>
 * <b>Example 1:</b>
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * <p>
 * <b>Example 2:</b>
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 */
@Slf4j
public class QuadrupleSumToTarget {

    public static List<List<Integer>> searchQuadruplets(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                searchPairs(nums, target, i, j, quadruplets);
            }
        }

        return quadruplets;
    }

    private static void searchPairs(int[] arr, int targetSum, int first, int second, List<List<Integer>> quadruplets) {
        int left = second + 1;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[first] + arr[second] + arr[left] + arr[right];
            if (sum == targetSum) {
                quadruplets.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
                left++;
                right--;

                while (left < right && arr[left] == arr[left - 1])
                    left++;
                while (left < right && arr[right] > arr[right + 1])
                    right--;

            } else if (sum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        log.info("Result = {}", QuadrupleSumToTarget.searchQuadruplets(new int[]{4, 1, 2, -1, 1, -3}, 1));
        log.info("Result = {}", QuadrupleSumToTarget.searchQuadruplets(new int[]{2, 0, -1, 1, -2, 2}, 2));
    }

}
