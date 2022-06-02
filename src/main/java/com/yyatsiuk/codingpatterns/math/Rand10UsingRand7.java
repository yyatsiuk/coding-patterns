package com.yyatsiuk.codingpatterns.math;

import java.util.random.RandomGenerator;

/**
 * <a href="https://leetcode.com/problems/implement-rand10-using-rand7/">470. Implement Rand10() Using Rand7()</a>
 */
public class Rand10UsingRand7 {

    public int rand10() {
        int num = Integer.MAX_VALUE;
        while (num >= 40) {
            num = (rand7() - 1) * 7 + (rand7() - 1); // range(0, 42) + range(0, 6) = range(0, 48)
        }

        return (num % 10) + 1;
    }

    private int rand7() {
        return RandomGenerator.getDefault().nextInt(1, 8);
    }

}
