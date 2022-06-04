package com.yyatsiuk.codingpatterns.prefix_sum;

/**
 * <a href="https://leetcode.com/problems/range-sum-query-mutable/">307. Range Sum Query - Mutable</a>
 */
public class NumArray {

    private final int[] tree;
    private final int[] original;

    public NumArray(int[] values) {
        this.tree = new int[values.length + 1];
        this.original = values;
        System.arraycopy(values, 0, tree, 1, values.length);

        for (int i = 1; i < tree.length; i++) {
            int j = i + Integer.lowestOneBit(i);
            if (j < tree.length) {
                tree[j] = tree[j] + tree[i];
            }
        }
    }

    public void update(int index, int val) {
        int oldVal = original[index];
        original[index] = val;

        index++;
        int diff = val - oldVal;
        while (index < tree.length) {
            tree[index] += diff;
            index += Integer.lowestOneBit(index);
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum(right) - prefixSum(left - 1);
    }

    private int prefixSum(int i) {
        i++;
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= Integer.lowestOneBit(i);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4};

        NumArray numArray = new NumArray(ints);
        numArray.update(0, 10);
        numArray.update(1, 5);
        System.out.println(numArray.sumRange(0, 2));
    }
}
