package com.yyatsiuk.codingpatterns.fast_and_slow_pointers;

/**
 * <a href="https://leetcode.com/problems/happy-number/">202. Happy Number</a>
 * <p>
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * <ul>
 * <li>Starting with any positive integer, replace the number by the sum of the squares of its digits.</li>
 * <li>Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.</li>
 * <li>Those numbers for which this process ends in 1 are happy.</li>
 * </ul>
 * Return true if n is a happy number, and false if not.
 * <b>Example 1:</b>
 * Input: n = 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        while (fast != 1) {
            slow = getNextNumber(slow);
            fast = getNextNumber(getNextNumber(fast));

            if (slow == fast) {
                return false;
            }
        }

        return true;
    }

    private static int getNextNumber(int num) {
        int result = 0;
        while (num != 0) {
            int lastDigit = num % 10;
            result += lastDigit * lastDigit;
            num /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        boolean happy = isHappy(19);
        System.out.println("happy = " + happy);
    }

}
