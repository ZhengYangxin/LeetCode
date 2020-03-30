package com.zyx.leetcode.question0033_search;

/**
 *
 * 非递归实现
 *
 * 时间复杂度O(logn)
 * 空间复杂度O(1)
 *
 * 执行耗时:1 ms,击败了92.84% 的Java用户, 内存消耗:38.2 MB,击败了11.81% 的Java用户
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution1 = new Solution2();
        int result = solution1.search(new int[]{4,5,6,7,0,1,2}, 3);
        System.out.println("args = [" + result + "]");
    }

    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

}
