package com.zyx.leetcode.question0154_find_min;

public class Solution1 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] <= nums[right]) {
                return nums[left];
            }

            int mid = left + ((right - left) >> 1);

            if (nums[left] == nums[mid]) {

                for (int i = left; i <= right; i++) {
                    if (nums[i] <= nums[right]) {
                        return nums[i];
                    }
                }
//                left++;
//                continue;
            }

            if (nums[left] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int result = solution1.findMin(new int[]{3,1,3});
        System.out.println("result = " + result);
    }
}
