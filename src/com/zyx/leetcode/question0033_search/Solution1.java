package com.zyx.leetcode.question0033_search;

/**
 *
 * 递归实现
 *
 *
 * 执行耗时:1 ms,击败了92.84% 的Java用户, 内存消耗:38.2 MB,击败了11.81% 的Java用户
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int result = solution1.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        System.out.println("args = [" + result + "]");
    }

    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }

       return  innerSearch(nums, 0, nums.length - 1, target);

    }

    private int innerSearch(int[] nums, int start, int end, int target) {
        if(nums[start]==target) return start;  // 用例[1] 结果0
        if(nums[end]==target) return end;
        if (start >= end) {
            return -1;
        }

        int mid = ((end - start) >> 1) + start;  //第一次结题，(end - start) >> 1 + start  算数运算的顺序错误，需要将卫衣运算括号起来

        if (nums[mid] == target) {
            return mid;
        }

        if (nums[start] < nums[mid]) {
            if (nums[start] <= target && target < nums[mid]) {
                return innerSearch(nums, start, mid - 1, target);
            } else {
                return innerSearch(nums, mid, end, target);
            }
        } else {
            if (nums[mid] < target && target <= nums[end]) {
                return innerSearch(nums, mid + 1, end, target);
            } else {
                return innerSearch(nums, start, mid, target);
            }
        }
    }
}
