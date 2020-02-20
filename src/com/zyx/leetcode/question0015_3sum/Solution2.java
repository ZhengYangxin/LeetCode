package com.zyx.leetcode.question0015_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 *
 * 双指针法
 * 思路
 * 1. 先将元素进行排序
 * 2. 定义k,i,j指针，k为遍历的起始元素，i = k+1是左边界元素，j = nums.length -1 为最又边界元素
 * 3. 每次挪动k，在[i,j]中寻找符合条件的值 nums[k] + nums[i] + nums[j] = 0;
 * 4. 在每次k值确定的情况下，通过移动左右i，j指针寻找符合条件的i,j
 * 5. 注意去重
 *
 * 时间复杂度是O(n ^ 2)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行耗时:40 ms,击败了56.64% 的Java用户，内存消耗:46.3 MB,击败了90.37% 的Java用户
 */
public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        // nums[k] + nums[i] + nums[j] = 0
        for (int k = 0; k < nums.length - 2; k++) {
            // 当最小值nums[k]> 0，则不存在解
            if (nums[k] > 0) break;

            // 若nums[k] == nums[k -1]，则意味着重复解
            if (k > 0 && nums[k] == nums[k -1]) continue;

            int i = k + 1, j = nums.length - 1;

            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];

                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }

        }

        return res;
    }
}
