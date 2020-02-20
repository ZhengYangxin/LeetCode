package com.zyx.leetcode.question0590_postorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 *
 *
 * 参考589的先序遍历
 * 先序遍历  根 1234 子节点
 *
 * 后续遍历 1234子节点 根
 *
 * 可以让先序遍历字节点的输出顺序 改为 根 子节点倒序 即 根 4321
 *
 * 此时先序的结构，反转，则得到后序遍历的结构  1234 根
 */
public class Solution2 {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node != null) {
                list.add(node.val);
                if (!node.children.isEmpty()) {
                    for (Node child : node.children) {
                        stack.push(child);
                    }
                }
            }
        }

        Collections.reverse(list);
        return list;
    }

}
