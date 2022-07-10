package com.yyatsiuk.codingpatterns.monotonous_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/trapping-rain-water/">42. Trapping Rain Water</a>
 */
public class TrappingRainingWater {

    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int totalWater = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int currentBlock = height[stack.pop()];
                if (!stack.isEmpty()) {
                    int prevMax = height[stack.peek()];
                    int water = Math.min(prevMax, height[i]) - currentBlock;

                    int length = i - stack.peek() - 1;
                    totalWater += water * length;
                }
            }

            stack.push(i);
        }

        return totalWater;
    }

}
