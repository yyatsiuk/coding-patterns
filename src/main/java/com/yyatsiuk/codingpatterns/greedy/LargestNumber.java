package com.yyatsiuk.codingpatterns.greedy;

import java.util.Arrays;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/largest-number/">179. Largest Number</a>
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] numbers = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numbers, (num1, num2) -> {
            String order1 = num1 + num2;
            String order2 = num2 + num1;

            return order2.compareTo(order1);
        });

        if (Objects.equals("0", numbers[0])) return "0";

        return String.join("", numbers);
    }

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        String s = largestNumber.largestNumber(new int[]{559, 55, 34, 3, 669, 6, 668, 66, 2231, 344419, 344499});
        System.out.println(s);
    }

}
