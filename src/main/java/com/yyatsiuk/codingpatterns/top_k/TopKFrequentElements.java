package com.yyatsiuk.codingpatterns.top_k;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class TopKFrequentElements {

    public int[] topKFrequentWithHeap(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Map.Entry.comparingByValue());
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (k > 0) {
                minHeap.add(entry);
                k--;
            } else {
                Map.Entry<Integer, Integer> minEntry = minHeap.peek();
                if (entry.getValue() > minEntry.getValue()) {
                    minHeap.poll();
                    minHeap.add(entry);
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }

    public int[] topKFrequentWithQuickSelect(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> freqList = new ArrayList<>(freqMap.entrySet());
        partialSort(freqList, k, 0, freqList.size() - 1);

        return freqList.stream().limit(2).mapToInt(Map.Entry::getKey).toArray();
    }

    private void partialSort(List<Map.Entry<Integer, Integer>> list, int k, int lo, int hi) {
        if (lo == hi) {
            return;
        }

        int pivot = ThreadLocalRandom.current().nextInt(lo, hi + 1);
        swap(list, lo, pivot);
        int partition = partition(list, lo, hi);

        if (partition < k - 1) {
            partialSort(list, k, partition + 1, hi);
        } else if (partition > k - 1) {
            partialSort(list, k, lo, partition - 1);
        } else {
            return;
        }
    }


    private int partition(List<Map.Entry<Integer, Integer>> list, int lo, int hi) {
        int pivot = list.get(lo).getValue();
        int i = lo;
        for (int j = lo + 1; j <= hi; j++) {
            if (list.get(j).getValue() > pivot) {
                swap(list, ++i, j);
            }
        }

        swap(list, lo, i);
        return i;
    }

    private void swap(List<Map.Entry<Integer, Integer>> list, int index1, int index2) {
        Map.Entry<Integer, Integer> tmp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, tmp);
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] ints = topKFrequentElements.topKFrequentWithQuickSelect(new int[]{5, 5, -1, 2, 2, 5, 1, 5, 0, 1, 3, -1, -1, 5, 3, 2, 3, 2, 3, 3}, 2);
        System.out.println(Arrays.toString(ints));
    }
}
