package org.chenguoyu.leetcode.dynamic_programing.optimal_substructure;

/**
 * 动态规划的解法
 */
public class Solution91_1 {
    Integer[] memory;

    public int numDecodings(String s) {
        memory = new Integer[s.length()];
        return numDecoding(s, 0);
    }

    private int numDecoding(String s, int index) {
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (memory[index] == null) {
            if (index < s.length() - 1 && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
                memory[index] = numDecoding(s, index + 1) + numDecoding(s, index + 2);
            } else {
                memory[index] = numDecoding(s, index + 1);
            }
        }
        return memory[index];
    }
}
