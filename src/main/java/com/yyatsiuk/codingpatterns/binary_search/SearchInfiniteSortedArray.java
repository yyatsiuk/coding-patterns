package com.yyatsiuk.codingpatterns.binary_search;

/**
 * <a href="https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/">702. Search in a Sorted Array of Unknown Size</a>
 */
public class SearchInfiniteSortedArray {

    static class ArrayReader {
        int[] arr;

        ArrayReader(int[] arr) {
            this.arr = arr;
        }

        public int get(int index) {
            if (index >= arr.length)
                return Integer.MAX_VALUE;
            return arr[index];
        }
    }

    public int search(ArrayReader reader, int target) {
        int start = 0, end = 1;
        while (reader.get(end) < target) {
            end *= 2;
        }
        return binarySearch(reader, target, start, end);
    }

    private static int binarySearch(ArrayReader reader, int key, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < reader.get(mid)) {
                end = mid - 1;
            } else if (key > reader.get(mid)) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

}
