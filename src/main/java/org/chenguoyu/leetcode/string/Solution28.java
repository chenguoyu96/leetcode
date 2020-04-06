package org.chenguoyu.leetcode.string;

import org.junit.Test;

/**
 * 28 实现 strStr()
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */
public class Solution28 {
    /*
    输入: haystack = "hello", needle = "ll"
    输出: 2
    暴力解法，超时
    */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            char c = haystack.charAt(i);
            if (c == needle.charAt(0)) {
                int j = i + 1;
                boolean flag = true;
                for (int k = 1; k < needle.length(); k++) {
                    if (j > haystack.length() - 1 || needle.charAt(k) != haystack.charAt(j++)) {
                        flag = false;
                    }
                }
                if (flag) {
                    return i;
                }
            }
        }
        return -1;
    }



    @Test
    public void main() {
//        System.out.println(strStr("hello", "ll"));
//        System.out.println(strStr("aaaaa", "bba"));
    }
}
