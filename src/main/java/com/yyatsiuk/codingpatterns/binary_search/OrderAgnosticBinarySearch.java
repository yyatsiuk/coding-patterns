package com.yyatsiuk.codingpatterns.binary_search;

public class OrderAgnosticBinarySearch {

    public static int search(int[] arr, int key) {
        boolean isAscending = arr[0] < arr[arr.length - 1];

        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (arr[middle] == key) {
                return middle;
            }
            if (isAscending) {
                if (key < arr[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            } else {
                if (key > arr[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(OrderAgnosticBinarySearch.search(new int[]{4, 6, 10}, 10));
        System.out.println(OrderAgnosticBinarySearch.search(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));
        System.out.println(OrderAgnosticBinarySearch.search(new int[]{10, 6, 4}, 10));
        System.out.println(OrderAgnosticBinarySearch.search(new int[]{10, 6, 4}, 4));
    }

}
