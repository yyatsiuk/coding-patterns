package com.yyatsiuk.codingpatterns.two_pointers;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome/">125. Valid Palindrome</a>
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(arr[left])) {
                left++;
            }

            while (right > left && !Character.isLetterOrDigit(arr[right])) {
                right--;
            }

            if (Character.toLowerCase(arr[left]) != Character.toLowerCase(arr[right])) return false;

            left++;
            right--;
        }

        return true;
    }

}
