package com.zyx.leetcode.question0017_letter_combinations;

import java.util.*;

/**
 *
 * 广度优先遍历
 * solve("2,3") = solve("2") + solve("3")
 *              = ([a,b,c]) + ([d,e,f])
 *              进行追加
 *
 * 执行耗时:7 ms,击败了16.90% 的Java用户,内存消耗:39 MB,击败了5.08% 的Java用户
 *
 */
public class Solution2 {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = digits.charAt(i) - '0';
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char c : mapping[x].toCharArray()) {
                    ans.add(t + c);
                }
            }
        }

        return ans;
    }

}
