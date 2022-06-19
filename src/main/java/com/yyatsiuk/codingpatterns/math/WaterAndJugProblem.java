package com.yyatsiuk.codingpatterns.math;

/**
 * <a href="https://leetcode.com/problems/water-and-jug-problem/">365. Water and Jug Problem</a>
 */
public class WaterAndJugProblem {

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) return false;
        if (jug1Capacity == targetCapacity ||
                jug2Capacity == targetCapacity ||
                jug1Capacity + jug2Capacity == targetCapacity) return true;

        return (targetCapacity % gcd(jug1Capacity, jug2Capacity)) == 0;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

}
