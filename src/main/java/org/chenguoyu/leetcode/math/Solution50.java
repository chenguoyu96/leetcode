package org.chenguoyu.leetcode.math;

import org.junit.Test;

/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class Solution50 {
    /*
    输入: 2.00000, 10
    输出: 1024.00000
    */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long pow = n;
        if (pow < 0) {
            pow = -pow;
            x = 1 / x;
        }
        double result = 1;
        while (pow != 0) {
            if ((pow & 1) == 1) {
                result = x * result;
            }
            pow = pow >> 1;
            x *= x;
        }
        return result;
    }

    @Test
    public void main() {
        System.out.println(myPow(1.00000, -2147483648));
    }
}
