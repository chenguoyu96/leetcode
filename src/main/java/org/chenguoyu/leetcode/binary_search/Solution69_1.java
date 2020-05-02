package org.chenguoyu.leetcode.binary_search;

import org.junit.Test;

/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 暴力解法
 */
public class Solution69_1 {
    /*
    输入: 4
    输出: 2
    * */
    public int mySqrt(int x) {
        if (x==0){
            return 0;
        }
        if (x <= 2) {
            return 1;
        }
        int i = 2;
        while (true) {
            if (i * i == x) {
                return i;
            }
            if (i > x / i) {
                return i - 1;
            }
            i++;
        }
    }

    @Test
    public void main() {
//        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
    }
}
