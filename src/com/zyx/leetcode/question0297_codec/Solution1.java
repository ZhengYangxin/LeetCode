package com.zyx.leetcode.question0297_codec;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * 执行耗时:13 ms,击败了93.75% 的Java用户,内存消耗:38.6 MB,击败了85.43% 的Java用户
 */
public class Solution1 {

    public static String NN = "#";
    public static String SPLITE = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        rserialize(root, sb);
        return sb.toString();

    }

    private void rserialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NN).append(SPLITE);
            return;
        }
        sb.append(root.val).append(SPLITE);
        rserialize(root.left, sb);
        rserialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] datas = data.split(SPLITE);
        Queue<String> queue = new LinkedList<>(Arrays.asList(datas));
        return rdeserialize(queue);
    }

    private TreeNode rdeserialize(Queue<String> queue) {
        String str = queue.poll();
        if (str.equals(NN)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(str));
        root.left = rdeserialize(queue);
        root.right = rdeserialize(queue);
        return root;
    }
}
