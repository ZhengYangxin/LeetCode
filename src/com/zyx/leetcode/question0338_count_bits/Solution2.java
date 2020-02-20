package com.zyx.leetcode.question0338_count_bits;

public class Solution2 {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            ans[i] = getCount(i);
        }
        return ans;
    }

    private int getCount(int i) {
        int count = 0;
        while (i != 0) {
            count++;
            i = i & (i - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution2 solution1 = new Solution2();
        int[] result = solution1.countBits(5);
        for (int count : result) {
            System.out.println("count = " + count);
        }
    }
}
