package com.zyx.leetcode.question0016_three_sum_closest;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 *
 * 排序+双指针法
 *
 * 时间复杂度O(n^2)：n为数组的长度
 * 空间复杂度O(1)
 *
 * 执行耗时:7 ms,击败了56.60% 的Java用户,内存消耗:36.7 MB,击败了28.94% 的Java用户
 *
 */
public class Solution2 {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int k = 0; k < nums.length; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1,j = nums.length - 1;

            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (Math.abs(target - ans) > Math.abs(target - sum)) {
                    ans = sum;
                }
                if (sum > target) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else if (sum < target){
                    while (i < j && nums[i] == nums[++i]) ;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
