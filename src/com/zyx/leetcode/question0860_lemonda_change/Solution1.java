package com.zyx.leetcode.question0860_lemonda_change;

/**
 * 在卖柠檬找钱，柠檬1杯5美元
 * 客户可以用5，10，20美元来买，那我们找钱当然先用大的再用小的更有优势
 *
 * 贪心策略： 22 个 55 元等价于 11 个 1010 元。需要尽可能地多留 55 元在手上，防止 1010 元的顾客无法找零
 */
public class Solution1 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, tem = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                five--;
                tem++;
            } else {
                if (five == 0) {
                    return false;
                }
                if (tem > 0 && five > 0) {
                    tem--;
                    five--;
                } else {
                    five -= 3;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] bills = new int[]{5,5,10,10,20};
        boolean result = solution1.lemonadeChange(bills);
        System.out.println(result);

    }
}
