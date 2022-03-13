package com.yyatsiuk.codingpatterns.sliding_window;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
public class MaxFruitCountOf2Types {

    public static int findLength(char[] arr) {
        final int k = 2;
        int maxNumOfFruits = 0;
        int windowStart = 0;
        Map<Character, Integer> fruitTypes = new LinkedHashMap<>();

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char rightChar = arr[windowEnd];
            fruitTypes.put(rightChar, fruitTypes.getOrDefault(rightChar, 0) + 1);

            while (fruitTypes.size() > k) {
                char leftChar = arr[windowStart];
                fruitTypes.put(leftChar, fruitTypes.get(leftChar) - 1);

                if (fruitTypes.get(leftChar) == 0) {
                    fruitTypes.remove(leftChar);
                }

                windowStart++;
            }

            maxNumOfFruits = Math.max(windowEnd - windowStart + 1, maxNumOfFruits);
        }

        return maxNumOfFruits;
    }

    public static void main(String[] args) {
        log.info("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        log.info("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }

}
