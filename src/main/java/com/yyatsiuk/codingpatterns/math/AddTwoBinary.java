package com.yyatsiuk.codingpatterns.math;

/**
 * <a href="https://leetcode.com/problems/add-binary/">67. Add Binary</a>
 */
public class AddTwoBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        if (a.length() < b.length()) return addBinary(b, a);

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carryover = 0;
        while (i >= 0) {
            int digit1 = a.charAt(i) - '0';
            int digit2 = j < 0 ? 0 : b.charAt(j) - '0';

            int total = digit1 + digit2 + carryover;
            sb.append(total % 2);
            carryover = total / 2;

            i--;
            j--;
        }

        if (carryover > 0) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddTwoBinary addTwoBinary = new AddTwoBinary();
        System.out.println(addTwoBinary.addBinary("11", "11"));
    }

}
