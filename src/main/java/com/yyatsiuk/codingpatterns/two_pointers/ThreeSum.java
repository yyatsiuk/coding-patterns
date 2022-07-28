package com.yyatsiuk.codingpatterns.two_pointers;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/3sum/">15. 3Sum</a>
 */
@Slf4j
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum(i, nums, result);
            }
        }

        return result;
    }

    private void twoSum(int currIndex, int[] nums, List<List<Integer>> result) {
        int left = currIndex + 1;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right] + nums[currIndex];
            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                result.add(List.of(nums[left], nums[currIndex], nums[right]));
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
    }

    public List<List<Integer>> threeSumNoSort(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            if (duplicates.add(nums[i])) {
                for (int j = i + 1; j < nums.length; j++) {
                    int complement = -(nums[i] + nums[j]);
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        return new ArrayList<>(res);
    }


    public static void main(String[] args) {
        ThreeSum test = new ThreeSum();
        log.info("Result = {}", test.threeSum(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        log.info("Result = {}", test.threeSumNoSort(new int[]{-5, 2, -1, -2, 3}));
    }

}
