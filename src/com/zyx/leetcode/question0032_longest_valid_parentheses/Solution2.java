package com.zyx.leetcode.question0032_longest_valid_parentheses;

/**
 *
 * 双指针法
 * left 为统计左括号的个数， right右括号的个数，
 * 定义maxLength， 当left和right相等时更新maxLength长度， 当right > left, left,right 重置为0
 *
 * 同理从右往左在执行一次
 */
public class Solution2 {

    public int longestValidParentheses(String s) {
        int left = 0, right =0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * right);
            }else if (right > left) {
                left = right = 0;
            }

        }

        left = right = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                right++;
            }

            if (left == right) {
                maxLength = Math.max(maxLength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int result = solution2.longestValidParentheses("(()");
        System.out.println("result = " + result);
    }
}
