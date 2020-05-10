package com.zyx.leetcode.question1248_number_of_subarrays;

import java.util.Arrays;

public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        int feed = 0;
        int[] arr = new int[len +2];
        Arrays.fill(arr, 0);
        // 下标i，对应的奇数个数
        for (int i = 0; i < nums.length; i++) {
            if((nums[i] & 1) == 1) {
                // 只有出现奇数feed才会增加，arr数组的下标feed代表nums数组中到下标arr[feed]为止出现了feed个奇数
                arr[++feed] = i;
            }
        }

        arr[0] = -1;
        arr[feed + 1] = len;

        for (int i = 1; i < feed + 2; i++) {
            res += (arr[i] - arr[i - 1]) * (arr[i + k] - arr[i + k - 1]);
        }

        return res;
    }

}