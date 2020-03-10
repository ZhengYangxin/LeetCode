package com.zyx.leetcode.question0009_isPalindrome;

/**
 *
 * 若是回文数则一定不会越界，和负数
 *
 * 获得反转的数字，与原数字相同则为回文数
 */
public class Solution1 {
    public boolean isPalindrome(int x) {
//        当x的各位是0,则不可能是回文数，例如80
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        // 1221  12321  奇数偶数的判断
        return reverse == x || x == reverse / 10;

    }
}
