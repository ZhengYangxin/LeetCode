package com.zyx.leetcode.question0127_ladder_length;

import java.util.*;

public class Solution1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] visited = new boolean[wordList.size()];
        Queue<String> queue = new LinkedList<>();
        int count = 1;
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endWord)) {
                    return count;
                }
                for (int j = 0; j < wordList.size(); j++) {
                    if (!visited[j] && isValide(current, wordList.get(j))) {
                        visited[j] = true;
                        queue.add(wordList.get(j));
                    }
                }
            }
            count++;
        }
        return 0;
    }

    private boolean isValide(String current, String word) {
        int count = 0;
        for (int i = 0; i < current.length(); i++) {
            char currentChar = current.charAt(i);
            char wordChar = word.charAt(i);
            if (currentChar != wordChar) {
                count++;
            }
        }
        return count > 1 ? false : true;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int result = solution1.ladderLength("a", "c", Arrays.asList("a","b","c"));
        System.out.println("result = " + result);
    }
}
