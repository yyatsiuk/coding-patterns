package com.yyatsiuk.codingpatterns.dynamic_programming;

/**
 * <a href="416. Partition Equal Subset Sum">https://leetcode.com/problems/partition-equal-subset-sum/</a>
 */
public class PartitionEqualSubsetSum {

    /**
     * Time complexity:  O(N*S), where ‘N’ represents total numbers and ‘S’ is the total sum of all the numbers.
     * Space complexity: O(N*S)
     */
    public boolean canPartitionTopDown(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;

        Boolean[][] dp = new Boolean[nums.length][sum / 2 + 1];
        return this.canPartitionRecursive(dp, nums, sum / 2, 0);
    }

    private boolean canPartitionRecursive(Boolean[][] dp, int[] nums, int sum, int index) {
        if (sum == 0) return true;
        if (index >= nums.length) return false;

        boolean canPartition = false;
        if (dp[index][sum] != null) {
            return dp[index][sum];
        } else if (nums[index] <= sum) {
            canPartition = canPartitionRecursive(dp, nums, sum - nums[index], index + 1);
        }

        dp[index][sum] = canPartition || canPartitionRecursive(dp, nums, sum, index + 1);
        return dp[index][sum];
    }

    public boolean canPartitionBottomUp(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;
        boolean[][] dp = new boolean[nums.length][sum / 2 + 1];
        sum = sum / 2;

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int s = 1; s <= sum; s++) {
            dp[0][s] = (nums[0] == s);
        }

        for (int index = 1; index < nums.length; index++) {
            for (int s = 0; s <= sum; s++) {
                if (nums[index] <= s) {
                    dp[index][s] = dp[index - 1][s] || dp[index - 1][s - nums[index]];
                } else {
                    dp[index][s] = dp[index - 1][s];
                }
            }
        }

        return dp[nums.length - 1][sum];
    }
}
