package com.zyx.leetcode.question0017_letter_combinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * 参考20有效的括号
 * 22括号生成
 * 回溯法，递归
 *
 * 执行耗时:10 ms,击败了6.23% 的Java用户,内存消耗:39 MB,击败了5.08% 的Java用户
 *
 */
public class Solution1 {
    public List<String> letterCombinations(String digits) {
        Map<String, String> map = new HashMap<String, String>(){{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};

        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {  // 当输入为空字符串
            return res;
        }
        combinations("", 0, digits, res, map);
        return res;
    }

    private void combinations(String str, int level, String digits, List<String> res, Map<String, String> map) {
        if (level == digits.length()) {
            res.add(str);
            return;
        }

        char c = digits.charAt(level);
        String data = map.get(String.valueOf(c));

        for (int i = 0; i < data.length(); i++) {
            combinations(str + data.charAt(i), level + 1, digits, res, map);
        }
    }
}
