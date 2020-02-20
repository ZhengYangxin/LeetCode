package com.zyx.leetcode.question0433_min_mutation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先遍历
 *
 * 基因start，转变为end， 从基因库中选择，一步步转变为end
 *
 * 找出每一步改变最小的基因
 *
 */
public class Solution1 {
    public int minMutation(String start, String end, String[] bank) {
        boolean[] visited = new boolean[bank.length];
        Queue<String> queue = new LinkedList<>();
        int result = 0;

        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(end)) {
                    return result;
                }

                for (int j = 0; j < bank.length; j++) {
                    if (!visited[j] && isValid(bank[j], current)) {
                        visited[j] = true;
                        queue.add(bank[j]);
                    }
                }

            }
            result++;

        }
        return -1;
    }

    private boolean isValid(String bank, String current) {
        int count = 0;
        for (int i = 0; i < bank.length(); i++) {
            char bankChar = bank.charAt(i);
            char currentChar = current.charAt(i);

            if (bankChar != currentChar) {
                count++;
            }
        }
        return count > 1 ? false : true;
    }
}
