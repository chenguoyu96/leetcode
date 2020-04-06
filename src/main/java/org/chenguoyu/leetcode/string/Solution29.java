package org.chenguoyu.leetcode.string;

import org.junit.Test;

/**
 * 29. 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 */
public class Solution29 {
    /**
     * @param dividend 被除数
     * @param divisor  除数
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }
        // 是否都是正数或者负数
        boolean flag = true;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            flag = false;
        }
        long dividendLong = dividend;
        long divisorLong = divisor;
        dividendLong = dividendLong > 0 ? dividendLong : -dividendLong;
        divisorLong = divisorLong > 0 ? divisorLong : -divisorLong;
        int result = divide(dividendLong, divisorLong);
        if (!flag) {
            result = -result;
        }
        return result;
    }

    private int divide(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }
        int count = 1;
        long divisorTemp = divisor;
        while (dividend >= (divisorTemp + divisorTemp)) {
            count = count + count;
            divisorTemp = divisorTemp + divisorTemp;
        }
        return count + divide(dividend - divisorTemp, divisor);
    }

    @Test
    public void main() {
        System.out.println(divide(10, 3));
//        System.out.println(divide(7, -3));
//        System.out.println(divide(2147483647, 2));
//        System.out.println(divide(-2147483648, 2));
    }
}
