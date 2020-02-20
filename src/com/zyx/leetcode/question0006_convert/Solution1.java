package com.zyx.leetcode.question0006_convert;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 定义numRows的字符串存储对象StringBuilder
 *
 * list.get(i).append(c)： 把每个字符 c 填入对应行 s_is
 *
 * i += flag： 更新当前字符 c 对应的行索引；
 *
 * flag = - flag： 在达到 Z 字形转折点时，执行反向。
 */
public class Solution1 {
    public String convert(String s, int numRows) {
        if (numRows < 2) { // 0行或者1行
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int i = 0, flag = -1;

        for (char c : s.toCharArray()) {
            list.get(i).append(c);

            if (i == 0 || i == numRows -1) flag = -flag;

            i += flag;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            res.append(stringBuilder);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String result = solution1.convert("LEETCODEISHIRING", 4);
        System.out.println("leetcodeishiring = " + result);
    }
}
