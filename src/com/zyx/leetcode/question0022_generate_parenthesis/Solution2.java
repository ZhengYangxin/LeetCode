package com.zyx.leetcode.question0022_generate_parenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 动态规划
 * 1. 子问题， problemp[i] = problem[i] + 1
 *
 * 2. 状态定义 dp[i]
 *
 * 3. DP方程
 * 若  dp[i] 都是合法的括号肯定是以")"结尾
 *
 * 1. dp[i-1] 为 "("
 * dp[i] = dp[i-1] +1
 *
 */
public class Solution2 {

    public List<String> generateParenthesis(int n) {

        List<List<String>> dp = new ArrayList<>(n);

        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);

                for (String s1 : str1) {
                    for (String s2 : str2) {
                        // 枚举右括号的位置
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }

    public static void main(String[] args) {
        Solution2 solution1 = new Solution2();
        List<String> strings = solution1.generateParenthesis(3);

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
