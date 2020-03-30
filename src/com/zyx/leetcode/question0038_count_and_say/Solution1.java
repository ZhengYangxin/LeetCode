package com.zyx.leetcode.question0038_count_and_say;

/**
 * 动态规划
 *
 * dp[i] i为当前长度的所有字符串
 *
 * dp[i] = dp[i-1]中每个字符串的元素进行报数
 *
 *
 * 优化，只需要记录前一个字符串即可
 *
 */
public class Solution1 {
    public String countAndSay(int n) {
        String[] dp = new String[n];
        dp[0] = "1";

        for (int i = 1; i < n; i++) {
            int lastLen = dp[i - 1].length();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < lastLen; j++) {
                int k = j;
                while (k < lastLen - 1 && dp[i - 1].charAt(k) == dp[i - 1].charAt(k + 1)) {
                    k++;
                }
                sb.append((k - j + 1) + "");
                sb.append(dp[i - 1].charAt(j));
                j = k;
            }
        }

        return dp[n - 1];
    }

    public String countAndSayPro(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                int k = j;
                while (k < s.length() - 1 && s.charAt(k) == s.charAt(k + 1)) {
                    k++;
                }
                sb.append((k - j + 1) + "");
                sb.append(s.charAt(j));
            }
        }
        return s;
    }
}
