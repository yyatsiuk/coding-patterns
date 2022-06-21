package com.yyatsiuk.codingpatterns;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static int findMinRotated(List<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr.get(mid) > arr.get(right)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        int res = findMinRotated(arr);
        System.out.println(res);
    }

}
