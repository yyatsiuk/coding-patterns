package com.yyatsiuk.codingpatterns.math;

/**
 * <a href="https://leetcode.com/problems/powx-n/">50. Pow(x, n)</a>
 */
public class PowerOfNum {

    public double myPow(double x, int n) {
        if (n < 0) {
            n *= -1;
            x = 1 / x;
        }

        return myPowHelper(x, n);
    }

    private double myPowHelper(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double half = myPowHelper(x, n / 2);
        System.out.printf("n = %s; half = %s%n", n, half);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }

    public static void main(String[] args) {
        PowerOfNum powerOfNum = new PowerOfNum();
        double power = powerOfNum.myPow(2, 12);
        System.out.println(power);

    }

}
