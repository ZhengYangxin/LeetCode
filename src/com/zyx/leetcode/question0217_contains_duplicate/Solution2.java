package com.zyx.leetcode.question0217_contains_duplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * 哈希实现
 *
 * 执行耗时:9 ms,击败了72.05% 的Java用户,内存消耗:45.7 MB,击败了5.09% 的Java用户
 *
 */
public class Solution2 {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
