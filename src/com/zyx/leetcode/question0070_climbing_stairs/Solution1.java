package com.zyx.leetcode.question0070_climbing_stairs;

/**
 *
 * 暴力法
 *
 * 把所有可能的阶数进行组合
 * 有n个台阶
 *
 * 从第一个台阶可以 走一个，也可以走两个
 * 走到对应的台阶也有同样的选择走一个或者两个
 * 当能刚好走到n时意味着是一种方法，否则不是
 *
 * 从上可以看出就是一个子问题， 可以画出一个递归状态树， n = 3， current 从0开始
 *                0
 *         1              2
 *     2      3        3     4
 *   3  4   4  5     4   5  5 6
 *
 *
 * 递归
 *
 * 1. terminator
 *  走的台阶i>n 台阶个数 return 0
 *  i== n刚好走到n台阶  return 1；
 *
 * 2. logic
 * 每次都有两种走法
 *   即当前的的走法有current =   climb(i+1) + climb(i+2) 的种类
 *
 * 3. drill down
 * 进入下一个台阶 climb(i+1) + climb(i+2)
 *
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int result = solution.climbStairs(5);
        System.out.println("result = " + result);
    }
    public int climbStairs(int n) {

        return climb(0, n);
//        return climbUpdate(0, n, new int[n+1]);

    }

    /**
     * 时间复杂度O(2n) 树形递归的大小为 2^n2
     * 空间复杂度O(n) 递归树的深度可以达到 n
     *
     * @param current
     * @param n
     * @return
     */
    private int climb(int current, int n) {
        if (current > n) {
            return 0;
        }

        if (current == n) {
            return 1;
        }
        return climb(current + 1, n)+ climb(current + 2, n);
    }


    /**
     * 优化版本，记忆化递归，
     *
     * 时间复杂度O(n) 树形递归的大小可以达到 n。
     * 空间复杂度O(n) 递归树的深度可以达到 n及， memo 数组用了 nn 的空间
     * @param current
     * @param n
     * @param memo
     * @return
     */
    private int climbUpdate(int current, int n, int[] memo) {
        if (current > n) {
            return 0;
        }
        if (current == n) {
            return 1;
        }

        if (memo[current] != 0) {
            return memo[current];
        }

        memo[current] = climb(current + 1, n) + climb(current + 2, n);
        return memo[current];
    }
}
