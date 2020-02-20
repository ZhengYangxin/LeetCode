package com.zyx.leetcode.question0069_my_sqrt;

public class SolutionExt {

    public double mySqrt(double x, double miss) {
        if (x == 0 || x == 1) {
            return x;
        }
        double left = 0;
        double right = x;
        while (left <= right) {
            double mid = left + (right - left) / 2;
            if (Math.abs(x - mid * mid) <= miss) {
                return mid;
            } else if (mid > x / mid) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        double num = 10;
        double result1 = Math.sqrt(num);
        System.out.println("result1 = " + result1);
        SolutionExt solutionExt = new SolutionExt();
        double result2 = solutionExt.mySqrt(num, Math.pow(10, -7));
        System.out.println("result2 = " + result2);

    }
}
