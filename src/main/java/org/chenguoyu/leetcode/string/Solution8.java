package org.chenguoyu.leetcode.string;

import org.junit.Test;

/**
 * 8. 字符串转换整数 (atoi)
 */
public class Solution8 {
    /*
    输入: "babad"
    输出: "bab"
    注意: "aba" 也是一个有效答案。
     */
    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i == str.length()) {
            return 0;
        }
        boolean flag = true;
        if (str.charAt(i) == '-') {
            flag = false;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        } else {
            if (!Character.isDigit(str.charAt(i))) {
                return 0;
            }
        }
        int result = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i++) - '0';
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
        }
        return flag ? result : -result;
    }

    @Test
    public void main() {
        System.out.println(myAtoi("2147483648"));
    }
}
