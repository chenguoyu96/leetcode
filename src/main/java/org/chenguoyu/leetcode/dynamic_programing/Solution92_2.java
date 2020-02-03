package org.chenguoyu.leetcode.dynamic_programing;

import java.util.List;

/**
 * 动态规划的解法
 */
public class Solution92_2 {
    public int numDecodings(String s) {
        int len = s.length();
        int[] memory = new int[len + 1];
        memory[len] = 1; //将递归法的结束条件初始化为 1
        //最后一个数字不等于 0 就初始化为 1
        if (s.charAt(len - 1) != '0') {
            memory[len - 1] = 1;
        }
        for (int index = len - 2; index >= 0; index--) {
            if (s.charAt(index) == '0') {
                continue;
            }
            if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
                memory[index] = memory[index + 1] + memory[index + 2];
            } else {
                memory[index] = memory[index + 1];
            }
        }
        return memory[0];
    }
}
