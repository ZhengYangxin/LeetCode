package com.zyx.leetcode.question0547_find_circle_num;

public class Solution1 {

    public int findCircleNum(int[][] M) {

        UnionFind parent = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    parent.union(i, j);
                }
            }
        }
        return parent.count;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int result = solution1.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        System.out.println("result = " + result);
    }

}

class UnionFind{

    public int count;
    private int[] parent;

    private int[] size;

    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p) {
//        while (p != parent[p]) {
//            // 路径压缩
//            parent[p] = parent[parent[p]];
//            p = parent[p];
//        }

        while (parent[p] != p)
            p = parent[p];
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        // 平衡优化，节点少的到多的
//        if (size[rootP] > size[rootQ]) {
//            parent[rootQ] = rootP;
//            size[rootP] += size[rootQ];
//        } else {
//            parent[rootP] = rootQ;
//            size[rootQ] += size[rootP];
//        }
        parent[rootP] = rootQ;
        count--;
    }
}
