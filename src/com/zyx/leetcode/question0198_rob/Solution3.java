package com.zyx.leetcode.question0198_rob;

/**
 * 针对方法2的DP方程 nums[i] = Math.max(nums[i-1], nums[i-2] + nums[i])
 * 可以看出类似于斐波拉切树的求值，并不需要一个数组，只需要两个变量
 */
public class Solution3 {
    public int rob(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

//        if (nums.length == 1) {
//            return nums[0];
//        }
//
//        int preMax = nums[0];
//        int currMax = Math.max(nums[1], preMax);
//
//        for (int i = 2; i < nums.length; i++) {
//            int temp = currMax;
//            currMax = Math.max(currMax, preMax + nums[i]);
//            preMax = temp;
//        }

        int preMax = 0;
        int currMax = 0;
        for (int num : nums) {
            int temp = currMax;
            currMax = Math.max(currMax, preMax + num);
            preMax = temp;
        }
        return currMax;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int result = solution3.rob(new int[]{1,2,3,1});
        System.out.println("result = " + result);
    }
}
