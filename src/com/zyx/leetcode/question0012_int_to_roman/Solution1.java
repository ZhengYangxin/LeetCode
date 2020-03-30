package com.zyx.leetcode.question0012_int_to_roman;

/**
 *
 * 执行耗时:5 ms,击败了91.35% 的Java用户,内存消耗:40.5 MB,击败了5.02% 的Java用户
 *
 * 时间复杂度：O(1)， 外层循环最多13次，内层循坏也是有限的
 * 空间复杂度O(1)，定义了两个数组
 *
 */
public class Solution1 {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < nums.length) {
            while (num >= nums[index]) {
                sb.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return sb.toString();
    }
}
