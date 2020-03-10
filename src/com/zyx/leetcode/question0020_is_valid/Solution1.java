package com.zyx.leetcode.question0020_is_valid;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * 时间复杂度O(n)
 * 空间复杂度O(n)：最糟糕的情况是把所有的开括号放入栈中
 * 执行耗时:3 ms,击败了58.70% 的Java用户,内存消耗:34.3 MB,击败了53.22% 的Java用户
 *
 */
public class Solution1 {
    public static Map<Character, Character> map = new HashMap<>();

    public Solution1() {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                char pop = stack.isEmpty() ? '#' : stack.pop();
                if (map.get(pop) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        boolean valid = solution1.isValid("()[]{}");
        System.out.println("isValid: " + valid);

    }
}
