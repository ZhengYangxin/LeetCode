package com.zyx.leetcode.question0022_generate_parenthesis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  广度优先遍历
 *  需要通过对象保存信息
 */
public class Solution3 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node("", 0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.left == n && node.right == n) {
                res.add(node.string);
            }

            if (node.left < n) {
                queue.add(new Node(node.string + "(", node.left + 1, node.right));
            }

            if (node.right < node.left) {
                queue.add(new Node(node.string + ")", node.left, node.right + 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution3 solution1 = new Solution3();
        List<String> strings = solution1.generateParenthesis(3);

        for (String string : strings) {
            System.out.println(string);
        }
    }
}

class Node{
    String string;
    int left;
    int right;

    public Node(String string, int left, int right) {
        this.string = string;
        this.left = left;
        this.right = right;
    }
}

