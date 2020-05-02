package org.chenguoyu.leetcode.binary_search;

import org.junit.Test;

/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 二分查找法
 */
public class Solution69_2 {
    /*
    输入: 4
    输出: 2
    * */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x <= 2) {
            return 1;
        }
        int left = 0;
        int right = x / 2;
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            long temp = (long) middle * middle;
            if (temp > x) {
                right = middle - 1;
            } else if (temp < x) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return right;
    }

    @Test
    public void main() {
//        System.out.println(mySqrt(4));
//        System.out.println(mySqrt(6));
        System.out.println(mySqrt(8));
//        System.out.println(mySqrt(2147395599));
    }
}
