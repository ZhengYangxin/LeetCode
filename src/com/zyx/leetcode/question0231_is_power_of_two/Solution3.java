package com.zyx.leetcode.question0231_is_power_of_two;

public class Solution3 {
    public boolean isPowerOfTwo(int n) {
        for (int i = 0; i < 32; i++) {
            n = n % 2;
        }
        return n == 0;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        boolean powerOfTwo = solution3.isPowerOfTwo(3);
        System.out.println("powerOfTwo = " + powerOfTwo);
    }

}
