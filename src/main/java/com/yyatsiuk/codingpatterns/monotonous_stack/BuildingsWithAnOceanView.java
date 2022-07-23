package com.yyatsiuk.codingpatterns.monotonous_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/buildings-with-an-ocean-view/">1762. Buildings With an Ocean View</a>
 */
public class BuildingsWithAnOceanView {

    public int[] findBuildings(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop();
            }

            stack.push(i);
        }

        int[] ans = new int[stack.size()];
        int n = stack.size();
        for (int i = 0; i < n; i++) {
            ans[i] = stack.removeLast();
        }

        return ans;
    }

}
