package com.zyx.leetcode.question0670_maxi_num_swap;

public class Solution1 {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int[] bucket = new int[10];
        for (int i = 0; i < digits.length; i++) {
            bucket[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int j = 9; j > digits[i] - '0'; j--) {
                if (bucket[j] > i) {
                    char temp = digits[i];
                    digits[i] = digits[bucket[j]];
                    digits[bucket[j]] = temp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }
}
