package com.zyx.leetcode.question0022_generate_parenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS  深度优先遍历
 *
 * 执行耗时:1 ms,击败了99.69% 的Java用户,内存消耗:36.3 MB,击败了54.03% 的Java用户
 *
 */
public class Solution1 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(0, 0, n, "", list);
        return list;
    }

    private void generate(int left, int right, int n, String s, List<String> list) {
        if (left == n && right == n) {
            list.add(s);
            return;
        }

        if (left < n) {
            generate(left + 1, right, n, s + "(", list);
        }

        if (left > right) {
            generate(left, right+1, n, s + ")", list);
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        List<String> strings = solution1.generateParenthesis(3);

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
