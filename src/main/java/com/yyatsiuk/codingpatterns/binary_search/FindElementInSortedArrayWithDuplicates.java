package com.yyatsiuk.codingpatterns.binary_search;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Given a sorted array of integers and a target integer, find the first occurrence of the target and return its index.
 * Return -1 if the target is not in the array.
 * <p>
 * Input:
 * <p>
 * arr = [1, 3, 3, 3, 3, 6, 10, 10, 10, 100]
 * target = 3
 * Output: 1
 * <p>
 * Explanation: First occurrence of 3 is at index 1.
 * <p>
 * Input:
 * <p>
 * arr = [2, 3, 5, 7, 11, 13, 17, 19]
 * target = 6
 * Output: -1
 * <p>
 * Explanation: 6 does not exists in the array.
 */
public class FindElementInSortedArrayWithDuplicates {

    public static int findFirstOccurrence(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (arr.get(mid) > target) {
                right = mid - 1;
            } else if (arr.get(mid) < target) {
                left = mid + 1;
            } else {
                index = mid;
                right = mid - 1;
            }
        }
        return index;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = findFirstOccurrence(arr, target);
        System.out.println(res);
    }

}
