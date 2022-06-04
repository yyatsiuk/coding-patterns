package com.yyatsiuk.codingpatterns.strings;

public class SwapTwoPiecesOfString {

    public static String swap(char[] str, int pivotPosition) {
        if (str == null || str.length == 0) throw new IllegalArgumentException("");
        if (pivotPosition > str.length - 1 || pivotPosition <= 0) return new String(str);

        int hi = str.length - 1;
        int lo = pivotPosition - 1;
        while (lo >= 0) {
            moveToTheEnd(str, lo--, hi--);
        }

        return new String(str);
    }

    private static void moveToTheEnd(char[] str, int lo, int hi) {
        int current = lo;
        int next = current + 1;
        while (next <= hi) {
            char tmp = str[current];
            str[current] = str[next];
            str[next] = tmp;

            current = next;
            next++;
        }
    }

    public static void main(String[] args) {
        String result = SwapTwoPiecesOfString.swap("HelloWorld!".toCharArray(), 5);
        System.out.println(result);
    }
}
