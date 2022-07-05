package com.yyatsiuk.codingpatterns.two_pointers;

/**
 * <a href="https://leetcode.com/problems/get-the-maximum-score/">1537. Get the Maximum Score</a>
 */
public class GetTheMaximumScore {

    public int maxSum(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        long scores1 = 0, scores2 = 0;
        int i = 0, j = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) scores1 += nums1[i++];
            else if (nums1[i] > nums2[j]) scores2 += nums2[j++];
            else {
                scores1 = scores2 = Math.max(scores1 + nums1[i++], scores2 + nums2[j++]);
            }
        }

        while (i < m) scores1 += nums1[i++];
        while (j < n) scores2 += nums2[j++];

        return (int) (Math.max(scores1, scores2) % (1e9 + 7));
    }

}
