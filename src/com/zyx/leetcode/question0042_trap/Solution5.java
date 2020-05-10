package com.zyx.leetcode.question0042_trap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 维护一个单调递减的栈，当遇到比栈顶大的元素则取出栈顶，找到前一个比栈顶大的元素，计算top元素的储水量
 *
 * 时间复杂度为O(n)，只遍历了一次，每个元素最多只访问2次
 * 空间复杂度为O(n)
 *
 * 执行耗时:3 ms,击败了33.47% 的Java用户，内存消耗:38.6 MB,击败了13.01% 的Java用户
 */
public class Solution5 {

//    https://leetcode.wang/leetCode-42-Trapping-Rain-Water.html

    public int trap(int[] height) {
        int sum = 0;
        if (null == height || height.length == 0) {
            return sum;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;

                int h = Math.min(height[stack.peek()], height[i]) - height[top];
                int dist = (i - stack.peek() - 1);
                sum += dist * h;
            }
            stack.push(i);
        }

        return sum;
    }
}
