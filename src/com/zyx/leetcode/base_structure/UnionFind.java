package com.zyx.leetcode.base_structure;

/**
 * 并查集
 *
 * 使用场景
 * 组团和配对
 *
 *
 * 默认自己指向自己 parent[i] = i
 *
 * 当发生合并时 一个集合的领头元素，指向另一个的领头元素
 *
 * 搜索哦时，找父元素，直到p = parent[p]
 *
 * 用parent数组记录每个节点的父节点，相当于指向父节点的指针，所以parent数组内实际存储着一个森林 （若干个二叉树）
 *
 * 用size几个每棵树的重量，目的是在union后依旧拥有平衡性，而不会退化成链表，影响操作
 *
 * 在find函数中进行路径压缩，保证任意树的高度保持在常数，是unin复杂度为O(1)
 */
public class UnionFind {

    private int count;
    private int[] parent;
    private int[] size;

    public UnionFind(int n) {
        this.count = n;
        this.parent = new int[n];
        this.size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }

        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }

        count--;
    }
}
