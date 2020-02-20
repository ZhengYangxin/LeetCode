package com.zyx.leetcode.question0212_find_words;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (null == words || words.length == 0) {
            return res;
        }
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        int rows = board.length;
        if (rows == 0) {
            return res;
        }
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                helper(board, row, col, trie.root, res);
            }
        }
        return res;
    }

    private void helper(char[][] board, int row, int col, TreeNode node, List<String> res) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }

        char currChar = board[row][col];
        //当前节点遍历过或者将要遍历的字母在前缀树中不存在
        if (currChar == '$' || !node.contains(currChar)) {
            return;
        }

        node = node.get(currChar);
        if (node.word != null) {
            res.add(node.word);
            node.word = null;  // 去重
//            return;
        }
        char temp = board[row][col];
        //上下左右去遍历
        board[row][col] = '$';
        helper(board, row - 1, col, node, res);
        helper(board, row + 1, col, node, res);
        helper(board, row, col - 1, node, res);
        helper(board, row, col + 1, node, res);
        board[row][col] = temp;

    }

}


class Trie {

    public TreeNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.contains(currentChar)) {
                node.put(currentChar, new TreeNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd(word);

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node.contains(currentChar)) {
                node = node.get(currentChar);
            } else {
                return false;
            }
        }
        return node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currentChar = prefix.charAt(i);
            if (node.contains(currentChar)) {
                node = node.get(currentChar);
            } else {
                return false;
            }
        }
        return true;
    }

}

class TreeNode {
    private boolean end;
    private TreeNode[] links;
    private int N = 26;
    public String word;

    public TreeNode() {
        this.links = new TreeNode[N];
    }

    public boolean contains(char key) {
        return links[key - 'a'] != null;
    }

    public TreeNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TreeNode node) {
        links[ch - 'a'] = node;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(String word) {
        this.end = true;
        this.word = word;
    }
}