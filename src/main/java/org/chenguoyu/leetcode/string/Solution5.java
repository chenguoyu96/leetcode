package org.chenguoyu.leetcode.string;

import org.junit.Test;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class Solution5 {
    /*
    输入: "babad"
    输出: "bab"
    注意: "aba" 也是一个有效答案。
     */
    public String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        int beginIndex = 0, endIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = getPalindromeLength(s, i, i);
            int len2 = getPalindromeLength(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > (endIndex - beginIndex)) {
                beginIndex = i - (len - 1) / 2;
                endIndex = i + len / 2;
            }
        }
        return s.substring(beginIndex, endIndex + 1);
    }

    public int getPalindromeLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    @Test
    public void main() {
        System.out.println(longestPalindrome("babad"));
    }
}
