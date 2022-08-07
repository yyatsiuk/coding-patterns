package com.yyatsiuk.codingpatterns.math;

/**
 * <a href="https://leetcode.com/problems/reverse-integer/">7. Reverse Integer</a>
 */
public class ReverseInteger {

    public int reverse(int x) {
        int ans = 0;
        int boundaryMax = Integer.MAX_VALUE / 10;
        int boundaryMin = Integer.MIN_VALUE / 10;
        while (x != 0) {
            int digit = (x % 10);
            if ((ans > boundaryMax) || (ans == boundaryMax && digit > Integer.MAX_VALUE % 10)) return 0;
            if ((ans < boundaryMin) || (ans == boundaryMin && digit < Integer.MIN_VALUE % 10)) return 0;

            ans = ans * 10 + digit;
            x /= 10;
        }

        return ans;
    }

}
