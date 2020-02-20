package com.zyx.leetcode.question0125_is_palindrom;


/**
 *
 *
 * 执行耗时:3 ms,击败了95.41% 的Java用户
 * 			内存消耗:39.3 MB,击败了7.10% 的Java用户
 */
public class Solution1 {
    public boolean isPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return true;
        }

        char[] chs = s.toCharArray();

        int left = 0, right = s.length() - 1;

        while (left <= right) {
            if (!Character.isLetterOrDigit(chs[left])) {
                left++;
            } else if (!Character.isLetterOrDigit(chs[right])) {
                right--;
            } else if (Character.toLowerCase(chs[left]) != Character.toLowerCase(chs[right])) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        boolean result = solution1.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(result);

    }
}
