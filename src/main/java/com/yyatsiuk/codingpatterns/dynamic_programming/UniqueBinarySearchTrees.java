package com.yyatsiuk.codingpatterns.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/unique-binary-search-trees/">96. Unique Binary Search Trees</a>
 */
public class UniqueBinarySearchTrees {

    private final Map<Integer, Integer> memo = new HashMap<>();
    public int numTreesTopDown(int n) {
        if (n <= 1) {
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!memo.containsKey(i - 1)) {
                memo.put(i - 1, numTreesTopDown(i - 1));
            }
            if (!memo.containsKey(n - i)) {
                memo.put(n - i, numTreesTopDown(n - i));
            }

            count += memo.get(i - 1) * memo.get(n - i);
        }

        return count;
    }

}
