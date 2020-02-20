package com.zyx.leetcode.question0015_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 *
 * 暴力法
 * 思路
 * 1. 对元素进行排序
 * 2. 三层循环
 * 3. 判断当前层级元素是否符合条件，以及对当前层级元素进行去重
 *
 * 时间复杂度是O(n^3), 空间复杂度是O(1)
 *
 * 该解法，超时
 */
public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (nums[i] > 0) break;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {

                if (nums[i] + nums[j] > 0) break;

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum > 0) break;
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    if (sum == 0) {
                        List<Integer> result = Arrays.asList(nums[i], nums[j], nums[k]);
                        res.add(result);
                    }
                }
            }
        }

        return res;
    }
}
