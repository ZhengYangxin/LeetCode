package com.zyx.leetcode.question0127_ladder_length;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<Integer> res = new ArrayList<>();
        helper(beginWord, endWord, wordList, new boolean[wordList.size()], 0, res);
        return res.isEmpty() ? 0 : res.get(0);
    }

    private void helper(String currentWord, String endWord, List<String> wordList, boolean[] visited, int level, List<Integer> res) {
        if (level == wordList.size() + 1) {
            res.add(0);
            return;
        }

        if (currentWord.equals(endWord)) {
            res.add(level);
            return;
        }

        for (int i = 0; i < wordList.size(); i++) {
            if (!visited[i] && isValid(currentWord, wordList.get(i))) {
                visited[i] = true;
                currentWord = wordList.get(i);
                helper(currentWord, endWord, wordList, visited, level + 1, res);
            }
        }
//        return min == Integer.MAX_VALUE ? 0 : min;
    }
    private boolean isValid(String currentWord, String word) {
        int count = 0;
        for (int i = 0; i < currentWord.length(); i++) {
            char currentChar = currentWord.charAt(i);
            char wordChar = word.charAt(i);
            if (currentChar != wordChar) {
                count++;
            }
        }
        return count > 1 ? false : true;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int result = solution2.ladderLength("a", "c", Arrays.asList("a","b","c"));
        System.out.println("result = " + result);
    }

}
