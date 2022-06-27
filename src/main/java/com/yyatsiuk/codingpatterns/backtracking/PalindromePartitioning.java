package com.yyatsiuk.codingpatterns.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/palindrome-partitioning/">131. Palindrome Partitioning</a>
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void partition(String s, int index, List<String> partition, List<List<String>> result) {
        if (index >= s.length()) {
            result.add(new ArrayList<>(partition));
            return;
        }

        for (int endIndex = index; endIndex < s.length(); endIndex++) {
            if (isPalindrome(s, index, endIndex)) {
                partition.add(s.substring(index, endIndex + 1));
                partition(s, endIndex + 1, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning solution = new PalindromePartitioning();
        List<List<String>> result = solution.partition("aabbaa");
        System.out.println(result);
    }
}
