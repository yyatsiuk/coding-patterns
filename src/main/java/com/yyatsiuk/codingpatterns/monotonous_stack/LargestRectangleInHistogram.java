package com.yyatsiuk.codingpatterns.monotonous_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/">84. Largest Rectangle in Histogram</a>
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> monoStack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!monoStack.isEmpty() && heights[i] <= heights[monoStack.peek()]) {
                int height = heights[monoStack.pop()];
                int left = monoStack.isEmpty() ? -1 : monoStack.peek();
                maxArea = Math.max(maxArea, (i - left - 1) * height);
            }
            monoStack.push(i);
        }

        while (!monoStack.isEmpty()) {
            int height = heights[monoStack.pop()];
            int leftLimit = monoStack.isEmpty() ? -1 : monoStack.peek();
            int width = heights.length - leftLimit - 1;
            maxArea = Math.max(maxArea, width * height);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram test = new LargestRectangleInHistogram();
        int rectangleArea = test.largestRectangleArea(new int[]{2, 4});
        System.out.println(rectangleArea);
    }

}
