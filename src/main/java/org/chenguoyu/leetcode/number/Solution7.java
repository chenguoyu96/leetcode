package org.chenguoyu.leetcode.number;

import org.junit.Test;

/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Solution7 {
    /*
    输入: 123
    输出: 321
     */
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        // x是否是正数
        boolean flag = x > 0;
        x = Math.abs(x);
        int result = 0;
        while (x > 0) {
            int value = x % 10;
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = result * 10 + value;
            x /= 10;
        }
        return flag ? result : -result;
    }

    @Test
    public void main() {
        System.out.println(reverse(123));
//        System.out.println(reverse(10));
//        System.out.println(reverse(1534236469));
    }
}