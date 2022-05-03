package com.yyatsiuk.codingpatterns.bit_manipulations;

/**
 * <a href="https://leetcode.com/problems/flipping-an-image/">832. Flipping an Image</a>
 */
public class FlipImage {

    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] pixelsLine : image) {
            reverse(pixelsLine);
            invert(pixelsLine);
        }

        return image;
    }

    private void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    private void invert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] ^ 1;
        }
    }

}
