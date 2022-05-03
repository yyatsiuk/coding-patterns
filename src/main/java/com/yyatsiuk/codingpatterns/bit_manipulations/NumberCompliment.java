package com.yyatsiuk.codingpatterns.bit_manipulations;

/**
 * <a href="https://leetcode.com/problems/number-complement/">476. Number Complement</a>
 */
public class NumberCompliment {

    public static int findComplement(int num) {
         if (num == 0) return 1;
        int todo = num, bit = 1;
        while (todo != 0) {
            num = num ^ bit;
            bit = bit << 1;
            todo = todo >> 1;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println("findComplement(5) = " + findComplement(5));
        System.out.println("findComplement(150) = " + findComplement(150));
    }

}
