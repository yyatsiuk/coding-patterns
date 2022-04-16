package com.yyatsiuk.codingpatterns.binary_search;

/**
 * <a href="https://leetcode.com/problems/search-insert-position/">35. Search Insert Position</a>
 */
public class SearchInsertPosition {

    public static int searchCeilingOfANumber(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (key == arr[middle]) {
                return middle;
            }

            if (key < arr[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        System.out.println(SearchInsertPosition.searchCeilingOfANumber(new int[]{4, 6, 10}, 6));
        System.out.println(SearchInsertPosition.searchCeilingOfANumber(new int[]{1, 3, 8, 10, 15}, 12));
        System.out.println(SearchInsertPosition.searchCeilingOfANumber(new int[]{4, 6, 10}, 17));
        System.out.println(SearchInsertPosition.searchCeilingOfANumber(new int[]{4, 6, 10}, -1));
        System.out.println(SearchInsertPosition.searchCeilingOfANumber(new int[]{1, 3, 5, 6}, 7));
    }

}
