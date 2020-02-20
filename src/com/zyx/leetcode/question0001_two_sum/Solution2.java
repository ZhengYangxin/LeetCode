package com.zyx.leetcode.question0001_two_sum;

import java.util.*;

/**
 * 哈希法 + 双指针
 * 思路
 * 1. 用哈希表记录nums[i]元素对应的索引,由于元素存在重复所以索引的保存用list
 * 2. 对数组进行排序，通过移动左右边界索引left，right，的元素值与target比较，得到符合条件的值
 * 注意 当nums[left] == nums[right]的情况，索引的取值
 *
 * 时间复杂度O(n)：其中n为nums数组的长度
 * 空间复杂度O(m)：其中m为nums数组中不同元素的数量
 * 执行耗时:7 ms,击败了57.38% 的Java用户，内存消耗:37.8 MB,击败了23.32% 的Java用户
 */
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }

        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{map.get(nums[left]).get(0), nums[left] == nums[right] ? map.get(nums[right]).get(1) : map.get(nums[right]).get(0)};
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[0];
    }
}
