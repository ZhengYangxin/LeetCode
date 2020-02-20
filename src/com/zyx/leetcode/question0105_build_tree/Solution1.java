package com.zyx.leetcode.question0105_build_tree;

/**
 * 在先序遍历中，第一个元素是根节点
 *
 * 在中序遍历中，根节点的位置i_root_index,将中序分为所有两个子树
 *
 * 从中序的左右子树，可以得到左子树的个数和右子树的个数
 *
 *
 * 循环操作
 */
public class Solution1 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return _build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode _build(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart == pEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pStart]);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        int leftNum = index - iStart;

        root.left = _build(preorder, pStart + 1, pStart + leftNum + 1, inorder, iStart, index);
        root.right = _build(preorder, pStart + leftNum + 1, pEnd, inorder, index + 1, iEnd);
        return root;
    }
}
