package com.yyatsiuk.codingpatterns.bit_manipulations;

/**
 * <a href="https://leetcode.com/problems/reverse-bits/">190. Reverse Bits</a>
 */
public class ReverseBits {

    /**
     * <a href="https://www.youtube.com/watch?v=KE5Axm7uzok">Good Explanation</a>
     */
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= (n & 1);
            n >>= 1;
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(ReverseBits.reverseBits(4));
    }

}
