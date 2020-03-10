package com.zyx.leetcode.question0152_max_product;

/**
 * 重复性（分治） problem(i) = Math.max(problem(i-1), 1) * problem(i)
 * 状态方程 nums[i]
 *
 * dp方程 dp[i] = Math.max(problem(i-1), 1) * problem(i)
 *
 * 因为元素存在正负数
 * 当为整数时 max[i] = Math.max(problem(i-1), 1) * problem(i)
 *
 * 负数时， min[i] = Math.min(problem(i-1), 1) * problem(i)
 *
 * 取最大值 ans =
 *
 *
 */
public class Solution1 {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int iMin = nums[0];
        int iMax = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = iMin;
                iMin = iMax;
                iMax = temp;
            }
//            iMax = Math.max(iMax, 1) * nums[i];
//            iMin = Math.min(iMin, 1) * nums[i];
            iMax = Math.max(iMax * nums[i], nums[i]);
            iMin = Math.min(iMin * nums[i], nums[i]);

            ans = Math.max(ans, iMax);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int result = solution1.maxProduct(new int[]{0,2});
        System.out.println("result = " + result);

    }
}
