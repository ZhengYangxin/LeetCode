package com.zyx.leetcode.question0105_build_tree;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return _build(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    private TreeNode _build(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, Map<Integer, Integer> map) {
        if (pStart == pEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pStart]);
        int i_index_root = map.get(root.val);
        int leftNum = i_index_root - iStart;

        root.left = _build(preorder, pStart + 1, pStart + leftNum + 1, inorder, iStart, i_index_root, map);
        root.right = _build(preorder, pStart + leftNum + 1, pEnd, inorder, i_index_root + 1, iEnd, map);
        return root;
    }
}
