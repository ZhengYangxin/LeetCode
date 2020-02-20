package com.zyx.leetcode.question0001_two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希法，一次遍历
 * 思路
 * 1. 用哈希表记录nums[i]元素对应的索引。
 * 2. 比较在哈希表中是否存在符合条件的元素
 * 
 * 执行耗时:3 ms,击败了97.31% 的Java用户,内存消耗:38 MB,击败了14.78% 的Java用户
 */
public class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[]{map.get(num), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
