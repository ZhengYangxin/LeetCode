package com.zyx.leetcode.question0035_search_insert;

/**
 *
 * 二分法
 *
 * 时间复杂度O(logn)
 * 空间复杂度O(1)
 *
 * 执行耗时:0 ms,击败了100.00% 的Java用户，内存消耗:38.4 MB,击败了96.23% 的Java用户
 */
public class Solution1 {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = (end - start) / 2 + start;

            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
//        return start - 1;
        return start;
        // 因为 当只有两个数1，3，target = 2时，他的中间数是元素1，1<target，start++;
        // 接着 start == end, 中间数是3， 3> target, end --;
        // 循环结束
        // start 即是要返回的索引
    }
}
