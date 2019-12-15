package com.zyx.leetcode;

/**
 * @author pielan
 * @date 15/12/2019 5:23 下午
 * @dec 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * solution:
 * 题目中加一操作是重点，可以分为两种
 * 1. 9以内的数字加1，不需要进位，结束返回值第
 * 2. 9及大于9的数字加一，需要进位，进行高一位的相同操作
 *
 * attention：
 * 当循环操作结束程序并未结束，说明数组是10的倍数减1的值9，99，999 ...
 * 则需要数组长度加1，将第一位置为1可得，10，100，1000
 */
public class Date3 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 9, 1};
        plusOne(nums);
        PrintUtils.print(nums);
    }

    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[1];
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
