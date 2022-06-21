package com.yyatsiuk.codingpatterns.binary_search;

/**
 * <a href="https://leetcode.com/problems/sqrtx/">69. Sqrt(x)</a>
 */
public class MySqrt {

    public static int sqrt(int x) {
        if (x < 2) return x;

        int left = 0;
        int right = x / 2;
        int sqrt = 0;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            long square = (long) mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                sqrt = mid;
                left = mid + 1;
            }
        }

        return sqrt;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(17));
    }
}
